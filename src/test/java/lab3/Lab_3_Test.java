package lab3;

import lab1.Car;
import lab1.Motorcycle;
import lab1.Truck;
import lab1.Vehicle;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lab_3_Test {

    private List<Vehicle> VEHICLE_LIST = List.of(
            new Car.CarBuilder().setBrand("Mercedes-Benz").setModel("C200").setYear(1997).setNumberOfDoors(5).build(),
            new Car.CarBuilder().setBrand("Mercedes-Benz").setModel("E240").setYear(1995).setNumberOfDoors(5).build(),
            new Car.CarBuilder().setBrand("Mercedes-Benz").setModel("C200").setYear(1993).setNumberOfDoors(5).build(),
            new Car.CarBuilder().setBrand("Opel").setModel("Zafira").setYear(2010).setNumberOfDoors(5).build(),
            new Motorcycle.MotorcycleBuilder().setBrand("Viper").setEngineType("4").setModel("F4").setYear(2005).build(),
            new Truck.TruckBuilder().setBrand("Renault").setModel("Magnum").setYear(2008).setCargoCapacity(10).build(),
            new Truck.TruckBuilder().setBrand("Man").setModel("TGX").setYear(2013).setCargoCapacity(25).build()
    );

    @Test()
    public void testCollections() {
        CarMarket carMarket = new CarMarket(VEHICLE_LIST);

        System.out.println("All vehicles");
        carMarket.getListOfAvailableVehicles().forEach(System.out::println);

        List<Vehicle> sortedByComparableInterface = new ArrayList<>(carMarket.getListOfAvailableVehicles());

        sortedByComparableInterface.sort(Vehicle::compareTo);

        System.out.println("\n\n\nSorted by own compareTo method:");
        sortedByComparableInterface.forEach(System.out::println);

        System.out.println("\n\n\nSorted by brand in ascending order:");
        carMarket.sortVehicleByBrandName(SortOrder.ASCENDING).forEach(System.out::println);

        System.out.println("\n\n\nSorted by brand in descending order:");
        carMarket.sortVehicleByBrandName(SortOrder.DESCENDING).forEach(System.out::println);

        System.out.println("\n\n\nSorted by model in ascending order:");
        carMarket.sortVehicleByModelName(SortOrder.ASCENDING).forEach(System.out::println);

        System.out.println("\n\n\nSorted by model in descending order:");
        carMarket.sortVehicleByModelName(SortOrder.DESCENDING).forEach(System.out::println);

        System.out.println("\n\n\nSorted by year in ascending order:");
        carMarket.sortVehicleByYear(SortOrder.ASCENDING).forEach(System.out::println);

        System.out.println("\n\n\nSorted by year in descending order:");
        carMarket.sortVehicleByYear(SortOrder.DESCENDING).forEach(System.out::println);

        System.out.println("\n\n\nFilter vehicles by brand with name Mercedes-Benz:");
        carMarket.filterVehicleByBrandName("Mercedes-Benz").forEach(System.out::println);

        System.out.println("\n\n\nFilter vehicles by model with name C200:");
        carMarket.filterVehicleByModelName("C200").forEach(System.out::println);

        System.out.println("\n\n\nFilter vehicles by year from 1996 to 2010:");
        carMarket.filterVehicleByYear(1996, 2010).forEach(System.out::println);
    }
}
