package lab3;

import lab1.Brand;
import lab1.Model;
import lab1.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Vehicle> VEHICLE_LIST = List.of(
            new Vehicle.VehicleBuilder().setModel(new Model.ModelBuilder().setBrand(new Brand.BrandBuilder().setName("Mercedes-Benz").build()).setName("C200").build())
                                        .setYear(1997).build(),
            new Vehicle.VehicleBuilder().setModel(new Model.ModelBuilder().setBrand(new Brand.BrandBuilder().setName("Mercedes-Benz").build()).setName("E240").build())
                                        .setYear(1995).build(),
            new Vehicle.VehicleBuilder().setModel(new Model.ModelBuilder().setBrand(new Brand.BrandBuilder().setName("Mercedes-Benz").build()).setName("C200").build())
                                        .setYear(1993).build(),
            new Vehicle.VehicleBuilder().setModel(new Model.ModelBuilder().setBrand(new Brand.BrandBuilder().setName("Opel").build()).setName("Zafira").build())
                                        .setYear(2010).build(),
            new Vehicle.VehicleBuilder().setModel(new Model.ModelBuilder().setBrand(new Brand.BrandBuilder().setName("Viper").build()).setName("F4").build())
                                        .setYear(2005).build(),
            new Vehicle.VehicleBuilder().setModel(new Model.ModelBuilder().setBrand(new Brand.BrandBuilder().setName("Renault").build()).setName("Magnum").build())
                                        .setYear(2008).build(),
            new Vehicle.VehicleBuilder().setModel(new Model.ModelBuilder().setBrand(new Brand.BrandBuilder().setName("Man").build()).setName("TGX").build())
                                        .setYear(2013).build()
    );

    public static void main(String args[]) {
        VehicleService VehicleService = new VehicleService(VEHICLE_LIST);

        System.out.println("All vehicles");
        VehicleService.getListOfAvailableVehicles().forEach(System.out::println);

        List<Vehicle> sortedByComparableInterface = new ArrayList<>(VehicleService.getListOfAvailableVehicles());

        sortedByComparableInterface.sort(Vehicle::compareTo);

        System.out.println("\n\n\nSorted by own compareTo method:");
        sortedByComparableInterface.forEach(System.out::println);

        System.out.println("\n\n\nSorted by brand in ascending order:");
        VehicleService.sortVehicleByBrandName(SortOrder.ASCENDING).forEach(System.out::println);

        System.out.println("\n\n\nSorted by brand in descending order:");
        VehicleService.sortVehicleByBrandName(SortOrder.DESCENDING).forEach(System.out::println);

        System.out.println("\n\n\nSorted by model in ascending order:");
        VehicleService.sortVehicleByModelName(SortOrder.ASCENDING).forEach(System.out::println);

        System.out.println("\n\n\nSorted by model in descending order:");
        VehicleService.sortVehicleByModelName(SortOrder.DESCENDING).forEach(System.out::println);

        System.out.println("\n\n\nSorted by year in ascending order:");
        VehicleService.sortVehicleByYear(SortOrder.ASCENDING).forEach(System.out::println);

        System.out.println("\n\n\nSorted by year in descending order:");
        VehicleService.sortVehicleByYear(SortOrder.DESCENDING).forEach(System.out::println);

        System.out.println("\n\n\nFilter vehicles by brand with name Mercedes-Benz:");
        VehicleService.filterVehicleByBrandName(new Brand.BrandBuilder().setName("Mercedes-Benz").build()).forEach(System.out::println);

        System.out.println("\n\n\nFilter vehicles by model with name C200:");
        VehicleService.filterVehicleByModelName(new Model.ModelBuilder().setBrand(new Brand.BrandBuilder().setName("Mercedes-Benz").build()).setName("C200").build()).forEach(System.out::println);

        System.out.println("\n\n\nFilter vehicles by year from 1996 to 2010:");
        VehicleService.filterVehicleByYear(1996, 2010).forEach(System.out::println);
    }
}
