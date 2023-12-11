package lab3;

import lab1.Brand;
import lab1.Model;
import lab1.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VehicleService implements IVehicleService {
    private List<Vehicle> listOfAvailableVehicles;

    public VehicleService(List<Vehicle> listOfAvailableVehicles) {
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
        List<Vehicle> sortedList = new ArrayList<>(listOfAvailableVehicles);
        Comparator<Vehicle> vehicleBrandComparator = (v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getModel().getBrand().compareTo(v2.getModel().getBrand()) : v2.getModel().getBrand().compareTo(v1.getModel().getBrand());
        sortedList.sort(vehicleBrandComparator);
        return sortedList;
    }

    @Override
    public List<Vehicle> sortVehicleByModelName(SortOrder sortOrder) {
        List<Vehicle> sortedList = new ArrayList<>(listOfAvailableVehicles);
        Comparator<Vehicle> vehicleModelComparator = (v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getModel().getName().compareTo(v2.getModel().getName()) : v2.getModel().getName().compareTo(v1.getModel().getName());
        sortedList.sort(vehicleModelComparator);
        return sortedList;
    }

    @Override
    public List<Vehicle> sortVehicleByYear(SortOrder sortOrder) {
        List<Vehicle> sortedList = new ArrayList<>(listOfAvailableVehicles);
        Comparator<Vehicle> vehicleYearComparator = (v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getYear() - v2.getYear() : v2.getYear() - v1.getYear();
        sortedList.sort(vehicleYearComparator);
        return sortedList;
    }

    @Override
    public List<Vehicle> filterVehicleByBrandName(Brand brand) {
        List<Vehicle> filteredVehicle = new ArrayList<>();
        for (Vehicle v : listOfAvailableVehicles) if (v.getModel().getBrand().equals(brand)) filteredVehicle.add(v);
        return filteredVehicle;
    }

    @Override
    public List<Vehicle> filterVehicleByModelName(Model model) {
        List<Vehicle> filteredVehicle = new ArrayList<>();
        for (Vehicle v : listOfAvailableVehicles) if (v.getModel().equals(model)) filteredVehicle.add(v);
        return filteredVehicle;
    }

    @Override
    public List<Vehicle> filterVehicleByYear(Integer yearFrom, Integer yearTo) {
        List<Vehicle> filteredVehicle = new ArrayList<>();
        for (Vehicle v : listOfAvailableVehicles) if (v.getYear() >= yearFrom && v.getYear() <= yearTo) filteredVehicle.add(v);
        return filteredVehicle;
    }
}
