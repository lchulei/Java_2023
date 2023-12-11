package lab3;

import lab1.Brand;
import lab1.Model;
import lab1.Vehicle;

import java.util.List;

public interface IVehicleService {

    List<Vehicle> sortVehicleByBrandName(SortOrder sortOrder);

    List<Vehicle> sortVehicleByModelName(SortOrder sortOrder);

    List<Vehicle> sortVehicleByYear(SortOrder sortOrder);

    List<Vehicle> filterVehicleByBrandName(Brand brand);

    List<Vehicle> filterVehicleByModelName(Model model);

    List<Vehicle> filterVehicleByYear (Integer yearFrom, Integer yearTo);
}
