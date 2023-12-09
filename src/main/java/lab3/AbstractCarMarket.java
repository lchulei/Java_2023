package lab3;

import lab1.Vehicle;

import java.util.List;

public abstract class AbstractCarMarket {
    protected List<Vehicle> listOfAvailableVehicles;

    public AbstractCarMarket(List<Vehicle> listOfAvailableVehicles) {
        this.listOfAvailableVehicles = listOfAvailableVehicles;
    }

    public List<Vehicle> getListOfAvailableVehicles() {
        return listOfAvailableVehicles;
    }

    public void setListOfAvailableVehicles(List<Vehicle> listOfAvailableVehicles) {
        this.listOfAvailableVehicles = listOfAvailableVehicles;
    }

    abstract List<Vehicle> sortVehicleByBrandName(SortOrder sortOrder);

    abstract List<Vehicle> sortVehicleByModelName(SortOrder sortOrder);

    abstract List<Vehicle> sortVehicleByYear(SortOrder sortOrder);

    abstract List<Vehicle> filterVehicleByBrandName(String brand);

    abstract List<Vehicle> filterVehicleByModelName(String model);

    abstract List<Vehicle> filterVehicleByYear (Integer yearFrom, Integer yearTo);
}
