package lab1;

import java.util.Objects;

/**
 * The {@code Brand} class represents a brand entity with a name.
 * It implements the {@code Comparable} interface to enable sorting based on brand name.
 */
public class Brand implements Comparable<Brand> {
    /** The name of the brand. */
    private String name;

    /**
     * Constructs a new {@code Brand} object with an empty name.
     */
    public Brand() {
    }

    /**
     * Constructs a new {@code Brand} object with the specified name.
     *
     * @param name the name of the brand.
     */
    public Brand(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the brand.
     *
     * @return the name of the brand.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the brand.
     *
     * @param name the new name for the brand.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a string representation of the {@code Brand} object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
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
        Brand brand = (Brand) o;
        return Objects.equals(name, brand.name);
    }

    /**
     * Returns a hash code value for the {@code Brand} object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Compares this {@code Brand} object with another {@code Brand} object based on their names.
     * The comparison is case-sensitive and uses the natural ordering of the names.
     *
     * @param o the {@code Brand} object to be compared.
     * @return a negative integer, zero, or a positive integer as this {@code Brand} object is
     *         less than, equal to, or greater than the specified {@code Brand} object.
     */
    @Override
    public int compareTo(Brand o) {
        return name.compareTo(o.name);
    }

    /**
     * The {@code BrandBuilder} class is a builder for creating {@code Brand} objects.
     */
    public static class BrandBuilder {
        /** The name of the brand. */
        private String name;

        /**
         * Sets the name of the brand.
         *
         * @param name the name of the brand.
         * @return the reference to this {@code BrandBuilder} object.
         */
        public BrandBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Builds a new {@code Brand} object with the specified parameters.
         *
         * @return a new {@code Brand} object.
         */
        public Brand build() {
            return new Brand(name);
        }
    }
}