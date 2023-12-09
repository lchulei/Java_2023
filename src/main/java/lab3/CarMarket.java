package lab3;

import lab1.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarMarket extends AbstractCarMarket {

    public CarMarket(List<Vehicle> listOfAvailableVehicles) {
        super(listOfAvailableVehicles);
    }

    @Override
    List<Vehicle> sortVehicleByBrandName(SortOrder sortOrder) {
        List<Vehicle> sortedList = new ArrayList<>(listOfAvailableVehicles);
        Comparator<Vehicle> vehicleBrandComparator = (v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getBrand().compareTo(v2.getBrand()) : v2.getBrand().compareTo(v1.getBrand());
        sortedList.sort(vehicleBrandComparator);
        return sortedList;
    }

    @Override
    List<Vehicle> sortVehicleByModelName(SortOrder sortOrder) {
        List<Vehicle> sortedList = new ArrayList<>(listOfAvailableVehicles);
        Comparator<Vehicle> vehicleModelComparator = (v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getModel().compareTo(v2.getModel()) : v2.getModel().compareTo(v1.getModel());
        sortedList.sort(vehicleModelComparator);
        return sortedList;
    }

    @Override
    List<Vehicle> sortVehicleByYear(SortOrder sortOrder) {
        List<Vehicle> sortedList = new ArrayList<>(listOfAvailableVehicles);
        Comparator<Vehicle> vehicleYearComparator = (v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getYear() - v2.getYear() : v2.getYear() - v1.getYear();
        sortedList.sort(vehicleYearComparator);
        return sortedList;
    }

    @Override
    List<Vehicle> filterVehicleByBrandName(String brand) {
        List<Vehicle> filteredVehicle = new ArrayList<>();
        for (Vehicle v : listOfAvailableVehicles) if (v.getBrand().equals(brand)) filteredVehicle.add(v);
        return filteredVehicle;
    }

    @Override
    List<Vehicle> filterVehicleByModelName(String model) {
        List<Vehicle> filteredVehicle = new ArrayList<>();
        for (Vehicle v : listOfAvailableVehicles) if (v.getModel().equals(model)) filteredVehicle.add(v);
        return filteredVehicle;
    }

    @Override
    List<Vehicle> filterVehicleByYear(Integer yearFrom, Integer yearTo) {
        List<Vehicle> filteredVehicle = new ArrayList<>();
        for (Vehicle v : listOfAvailableVehicles) if (v.getYear() >= yearFrom && v.getYear() <= yearTo) filteredVehicle.add(v);
        return filteredVehicle;
    }
}
