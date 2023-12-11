package lab5.models;

import java.util.Objects;

public class Vehicle {
    private int id;
    private Model model;
    private int year;

    public Vehicle() {}

    public Vehicle(int id, Model model, int year) {
        this.id = id;
        this.model = model;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model=" + model +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id == vehicle.id &&
                year == vehicle.year &&
                Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, year);
    }

    public static class VehicleBuilder {
        private int id;
        private Model model;
        private int year;

        public VehicleBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public VehicleBuilder setModel(Model model) {
            this.model = model;
            return this;
        }

        public VehicleBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(id, model, year);
        }
    }
}