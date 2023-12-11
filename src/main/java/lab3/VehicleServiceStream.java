package lab3;

import lab1.Brand;
import lab1.Model;
import lab1.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleServiceStream implements IVehicleService {
    private List<Vehicle> listOfAvailableVehicles;

    public VehicleServiceStream(List<Vehicle> listOfAvailableVehicles) {
        this.listOfAvailableVehicles = listOfAvailableVehicles;
    }

    public List<Vehicle> getListOfAvailableVehicles() {
        return listOfAvailableVehicles;
    }

    public void setListOfAvailableVehicles(List<Vehicle> listOfAvailableVehicles) {
        this.listOfAvailableVehicles = listOfAvailableVehicles;
    }

    @Override
    public List<Vehicle> sortVehicleByBrandName(SortOrder sortOrder) {
        return listOfAvailableVehicles.stream().sorted((v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getModel().getBrand().compareTo(v2.getModel().getBrand()) : v2.getModel().getBrand().compareTo(v1.getModel().getBrand())).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> sortVehicleByModelName(SortOrder sortOrder) {
        return listOfAvailableVehicles.stream().sorted((v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getModel().compareTo(v2.getModel()) : v2.getModel().compareTo(v1.getModel())).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> sortVehicleByYear(SortOrder sortOrder) {
        return listOfAvailableVehicles.stream().sorted((v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getYear() - v2.getYear() : v2.getYear() - v1.getYear()).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> filterVehicleByBrandName(Brand brand) {
        return listOfAvailableVehicles.stream().filter(v -> v.getModel().getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> filterVehicleByModelName(Model model) {
        return listOfAvailableVehicles.stream().filter(v -> v.getModel().equals(model)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> filterVehicleByYear(Integer yearFrom, Integer yearTo) {
        return listOfAvailableVehicles.stream().filter(v -> v.getYear() >= yearFrom && v.getYear() <= yearTo).collect(Collectors.toList());
    }
}
