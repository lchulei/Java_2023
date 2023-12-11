package lab1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The {@code Advertisement} class represents an advertisement for a vehicle, containing details such as
 * the vehicle information, price, contact details, and date of posting. It implements the {@code Comparable} interface
 * for sorting based on the date of posting and price.
 */
public class Advertisement implements Comparable<Advertisement> {
    /** The vehicle associated with the advertisement. */
    private Vehicle vehicle;

    /** The price of the vehicle in the advertisement. */
    private Integer price;

    /** Additional information about the advertisement. */
    private String information;

    /** The contact number provided in the advertisement. */
    private String contactNumber;

    /** The date when the advertisement was posted. */
    private LocalDate dateOfPosting;

    /**
     * Constructs a new {@code Advertisement} object with default values.
     */
    public Advertisement() {}

    /**
     * Constructs a new {@code Advertisement} object with the specified vehicle, price, information,
     * contact number, and date of posting.
     *
     * @param vehicle       the vehicle associated with the advertisement.
     * @param price         the price of the vehicle in the advertisement.
     * @param information   additional information about the advertisement.
     * @param contactNumber the contact number provided in the advertisement.
     * @param dateOfPosting the date when the advertisement was posted.
     */
    public Advertisement(Vehicle vehicle, Integer price, String information, String contactNumber, LocalDate dateOfPosting) {
        this.vehicle = vehicle;
        this.price = price;
        this.information = information;
        this.contactNumber = contactNumber;
        this.dateOfPosting = dateOfPosting;
    }

    /**
     * Gets the price of the vehicle in the advertisement.
     *
     * @return the price of the vehicle.
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Sets the price of the vehicle in the advertisement.
     *
     * @param price the new price of the vehicle.
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Gets the vehicle associated with the advertisement.
     *
     * @return the vehicle associated with the advertisement.
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Sets the vehicle associated with the advertisement.
     *
     * @param vehicle the new vehicle associated with the advertisement.
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Gets additional information about the advertisement.
     *
     * @return additional information about the advertisement.
     */
    public String getInformation() {
        return information;
    }

    /**
     * Sets additional information about the advertisement.
     *
     * @param information the new additional information about the advertisement.
     */
    public void setInformation(String information) {
        this.information = information;
    }

    /**
     * Gets the contact number provided in the advertisement.
     *
     * @return the contact number provided in the advertisement.
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the contact number provided in the advertisement.
     *
     * @param contactNumber the new contact number provided in the advertisement.
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Gets the date when the advertisement was posted.
     *
     * @return the date when the advertisement was posted.
     */
    public LocalDate getDateOfPosting() {
        return dateOfPosting;
    }

    /**
     * Sets the date when the advertisement was posted.
     *
     * @param dateOfPosting the new date when the advertisement was posted.
     */
    public void setDateOfPosting(LocalDate dateOfPosting) {
        this.dateOfPosting = dateOfPosting;
    }

    /**
     * Returns a string representation of the {@code Advertisement} object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Advertisement{" +
                "vehicle=" + vehicle.toString() +
                ", price=" + price +
                ", information='" + information + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", dateOfPosting=" + dateOfPosting +
                '}';
    }

    /**
     * Compares this {@code Advertisement} object with another {@code Advertisement} object based on
     * the date of posting and price. The comparison prioritizes the date of posting over the price.
     *
     * @param o the {@code Advertisement} object to be compared.
     * @return a negative integer, zero, or a positive integer as this {@code Advertisement} object is
     *         less than, equal to, or greater than the specified {@code Advertisement} object.
     * @throws NullPointerException if the specified {@code Advertisement} is null.
     */
    @Override
    public int compareTo(Advertisement o) {
        int dateComparison = dateOfPosting.compareTo(o.dateOfPosting);

        if (dateComparison != 0) {
            return dateComparison;
        } else {
            return price.compareTo(o.price);
        }
    }

    /**
     * The {@code AdvertisementBuilder} class is a builder for creating {@code Advertisement} objects.
     */
    public static class AdvertisementBuilder {
        /** The vehicle associated with the advertisement. */
        private Vehicle vehicle;

        /** The price of the vehicle in the advertisement. */
        private Integer price;

        /** Additional information about the advertisement. */
        private String information;

        /** The contact number provided in the advertisement. */
        private String contactNumber;

        /** The date when the advertisement was posted. */
        private LocalDate dateOfPosting;

        /**
         * Sets the price of the vehicle in the advertisement.
         *
         * @param price the price of the vehicle.
         */
        public AdvertisementBuilder setPrice(Integer price) {
            this.price = price;
            return this;
        }

        /**
         * Sets the vehicle associated with the advertisement.
         *
         * @param vehicle the vehicle associated with the advertisement.
         */
        public AdvertisementBuilder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        /**
         * Sets additional information about the advertisement.
         *
         * @param information additional information about the advertisement.
         */
        public AdvertisementBuilder setInformation(String information) {
            this.information = information;
            return this;
        }

        /**
         * Sets the contact number provided in the advertisement.
         *
         * @param contactNumber the contact number provided in the advertisement.
         */
        public AdvertisementBuilder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        /**
         * Sets the date when the advertisement was posted.
         *
         * @param dateOfPosting the date when the advertisement was posted.
         */
        public AdvertisementBuilder setDateOfPosting(LocalDate dateOfPosting) {
            this.dateOfPosting = dateOfPosting;
            return this;
        }

        /**
         * Builds a new {@code Advertisement} object with the specified parameters.
         *
         * @return a new {@code Advertisement} object.
         */
        public Advertisement build() {
            return new Advertisement(vehicle, price, information, contactNumber, dateOfPosting);
        }
    }
}