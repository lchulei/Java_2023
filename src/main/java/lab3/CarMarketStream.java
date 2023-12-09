package lab3;

import lab1.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarMarketStream extends AbstractCarMarket {

    public CarMarketStream(List<Vehicle> listOfAvailableVehicles) {
        super(listOfAvailableVehicles);
    }

    @Override
    List<Vehicle> sortVehicleByBrandName(SortOrder sortOrder) {
        List<Vehicle> sortedList = new ArrayList<>(listOfAvailableVehicles);
        Comparator<Vehicle> vehicleBrandComparator = (v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getBrand().compareTo(v2.getBrand()) : v2.getBrand().compareTo(v1.getBrand());
        return sortedList.stream().sorted(vehicleBrandComparator).collect(Collectors.toList());
    }

    @Override
    List<Vehicle> sortVehicleByModelName(SortOrder sortOrder) {
        List<Vehicle> sortedList = new ArrayList<>(listOfAvailableVehicles);
        Comparator<Vehicle> vehicleModelComparator = (v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getModel().compareTo(v2.getModel()) : v2.getModel().compareTo(v1.getModel());
        return sortedList.stream().sorted(vehicleModelComparator).collect(Collectors.toList());
    }

    @Override
    List<Vehicle> sortVehicleByYear(SortOrder sortOrder) {
        List<Vehicle> sortedList = new ArrayList<>(listOfAvailableVehicles);
        Comparator<Vehicle> vehicleYearComparator = (v1, v2) -> sortOrder == SortOrder.ASCENDING ? v1.getYear() - v2.getYear() : v2.getYear() - v1.getYear();
        return sortedList.stream().sorted(vehicleYearComparator).collect(Collectors.toList());
    }

    @Override
    List<Vehicle> filterVehicleByBrandName(String brand) {
        return listOfAvailableVehicles.stream().filter(v -> v.getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    List<Vehicle> filterVehicleByModelName(String model) {
        return listOfAvailableVehicles.stream().filter(v -> v.getModel().equals(model)).collect(Collectors.toList());
    }

    @Override
    List<Vehicle> filterVehicleByYear(Integer yearFrom, Integer yearTo) {
        return listOfAvailableVehicles.stream().filter(v -> v.getYear() >= yearFrom && v.getYear() <= yearTo).collect(Collectors.toList());
    }
}
