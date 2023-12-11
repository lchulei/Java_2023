package lab1;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The {@code Vehicle} class represents a general vehicle with a model and manufacturing year.
 * It implements the {@code Comparable} interface to enable sorting based on model and year.
 */
public class Vehicle implements Comparable<Vehicle> {


    /** The model of the vehicle. */
    @NotNull(message = "Model can't be null!")
    private Model model;


    /** The manufacturing year of the vehicle. */
    @NotNull(message = "Year can't be null!")
    @Min(value = 1900, message = "Year must be greater than 1900!")
    @Max(value = 2030, message = "Year must be less than 2030!")
    private Integer year;

    /**
     * Constructs a new {@code Vehicle} object with default values.
     */
    public Vehicle() {}

    /**
     * Constructs a new {@code Vehicle} object with the specified model, and year.
     *
     * @param model the model of the vehicle.
     * @param year  the manufacturing year of the vehicle.
     */
    public Vehicle(Model model, Integer year) {
        this.model = model;
        this.year = year;
    }

    /**
     * Gets the model of the vehicle.
     *
     * @return the model of the vehicle.
     */
    public Model getModel() {
        return model;
    }

    /**
     * Sets the model of the vehicle.
     *
     * @param model the new model for the vehicle.
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Gets the manufacturing year of the vehicle.
     *
     * @return the manufacturing year of the vehicle.
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the manufacturing year of the vehicle.
     *
     * @param year the new manufacturing year for the vehicle.
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model=" + model.toString() +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(model, vehicle.model) &&
                Objects.equals(year, vehicle.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year);
    }

    /**
     * Compares this {@code Vehicle} object with another {@code Vehicle} object based on model and year.
     * The comparison is case-sensitive and uses the natural ordering of the model and year.
     *
     * @param v the {@code Vehicle} object to be compared.
     * @return a negative integer, zero, or a positive integer as this {@code Vehicle} object is
     *         less than, equal to, or greater than the specified {@code Vehicle} object.
     * @throws NullPointerException if the specified {@code Vehicle} is null.
     */
    @Override
    public int compareTo(Vehicle v) {
        int modelComparison = model.compareTo(v.model);

        if (modelComparison != 0) {
            return modelComparison;
        } else {
            return Integer.compare(year, v.year);
        }
    }

    /**
     * The {@code VehicleBuilder} class is a builder for creating {@code Vehicle} objects.
     */
    public static class VehicleBuilder {
        /** The model of the vehicle. */
        private Model model;

        /** The manufacturing year of the vehicle. */
        private Integer year;

        /**
         * Sets the model of the vehicle.
         *
         * @param model the model of the vehicle.
         */
        public VehicleBuilder setModel(Model model) {
            this.model = model;
            return this;
        }

        /**
         * Sets the manufacturing year of the vehicle.
         *
         * @param year the manufacturing year of the vehicle.
         */
        public VehicleBuilder setYear(Integer year) {
            this.year = year;
            return this;
        }

//        private void validate(Vehicle vehicle) {
//            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
//
//            Set<String> validationMessages = new HashSet<>();
//            Set<ConstraintViolation<Vehicle>> constraintViolations = validator.validate(vehicle);
//
//            for(ConstraintViolation constraintViolation : constraintViolations) {
//                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
//                validationMessages.add(fieldName + " " + constraintViolation.getMessage());
//            }
//
//            if (!validationMessages.isEmpty()) {
//                throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationMessages));
//            }
//        }

        private void validate(Vehicle vehicle) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<String> validationMessages = new HashSet<>();
            Set<ConstraintViolation<Vehicle>> constraintViolations = validator.validate(vehicle);

            for(ConstraintViolation constraintViolation : constraintViolations) {
                System.out.println(constraintViolation.getMessage());
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                validationMessages.add(fieldName + " " + constraintViolation.getMessage());
            }

            if (!validationMessages.isEmpty()) {
                throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationMessages));
            }
        }

        /**
         * Builds a new {@code Vehicle} object with the specified parameters.
         *
         * @return a new {@code Vehicle} object.
         */
        public Vehicle build() {
            Vehicle vehicle = new Vehicle(model, year);
            validate(vehicle);
            return vehicle;
        }
    }
}