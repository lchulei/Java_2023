package lab1;

import java.util.Objects;

/**
 * The {@code Model} class represents a model entity with a name and a corresponding brand.
 * It implements the {@code Comparable} interface to enable sorting based on brand and model name.
 */
public class Model implements Comparable<Model> {
    /** The name of the model. */
    private String name;

    /** The brand associated with the model. */
    private Brand brand;

    /**
     * Constructs a new {@code Model} object with an empty name and no associated brand.
     */
    public Model() {
    }

    /**
     * Constructs a new {@code Model} object with the specified name and brand.
     *
     * @param name  the name of the model.
     * @param brand the brand associated with the model.
     */
    public Model(String name, Brand brand) {
        this.name = name;
        this.brand = brand;
    }

    /**
     * Gets the name of the model.
     *
     * @return the name of the model.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the model.
     *
     * @param name the new name for the model.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the brand associated with the model.
     *
     * @return the brand associated with the model.
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Sets the brand associated with the model.
     *
     * @param brand the new brand for the model.
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Returns a string representation of the {@code Model} object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", brand=" + brand.toString() +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the {@code o} argument;
     * {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(name, model.name) &&
                Objects.equals(brand, model.brand);
    }

    /**
     * Returns a hash code value for the {@code Model} object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, brand);
    }

    /**
     * Compares this {@code Model} object with another {@code Model} object based on their brands and names.
     * The comparison is case-sensitive and uses the natural ordering of the brand and name.
     * If the brands are different, the comparison is based on brand names. If the brands are the same,
     * the comparison is based on model names.
     *
     * @param o the {@code Model} object to be compared.
     * @return a negative integer, zero, or a positive integer as this {@code Model} object is
     *         less than, equal to, or greater than the specified {@code Model} object.
     */
    @Override
    public int compareTo(Model o) {
        if (brand.compareTo(o.brand) != 0) {
            return brand.compareTo(o.brand);
        } else {
            return name.compareTo(o.name);
        }
    }

    /**
     * The {@code ModelBuilder} class is a builder for creating {@code Model} objects.
     */
    public static class ModelBuilder {
        /** The name of the model. */
        private String name;

        /** The brand associated with the model. */
        private Brand brand;

        /**
         * Sets the name of the model.
         *
         * @param name the name of the model.
         * @return the reference to this {@code ModelBuilder} object.
         */
        public ModelBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the brand associated with the model.
         *
         * @param brand the brand associated with the model.
         * @return the reference to this {@code ModelBuilder} object.
         */
        public ModelBuilder setBrand(Brand brand) {
            this.brand = brand;
            return this;
        }

        /**
         * Builds a new {@code Model} object with the specified parameters.
         *
         * @return a new {@code Model} object.
         */
        public Model build() {
            return new Model(name, brand);
        }
    }
}