package lab4;

import lab1.Brand;
import lab1.Model;
import lab1.Vehicle;

public class Main {
    public static void main(String args[]) {
        Vehicle vehicle = new Vehicle.VehicleBuilder().setModel(new Model.ModelBuilder().setBrand(new Brand.BrandBuilder().setName("Mercedes-Benz").build()).setName("C200").build()).setYear(1997).build();

        System.out.println(vehicle);
    }
}
