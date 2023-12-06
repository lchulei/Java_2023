package lab1;

import org.testng.annotations.Test;

public class Lab_1_Test {

    @Test
    public void test() {
        Vehicle v = new Vehicle.VehicleBuilder().setBrand("Mercedes-Benz").setModel("C200").setYear(1997).build();
        Car c = new Car.CarBuilder().setBrand("Lada").setModel("1007").setYear(2000).setNumberOfDoors(5).build();
        Motorcycle m = new Motorcycle.MotorcycleBuilder().setBrand("Viper").setEngineType("4").setModel("F4").setYear(2005).build();
        Truck t = new Truck.TruckBuilder().setBrand("Renault").setCargoCapacity(10).setModel("Magnum").setYear(2008).build();

        System.out.println(v);
        System.out.println(c);
        System.out.println(m);
        System.out.println(t);
    }
}
