package lab5.models;

import java.sql.Date;
import java.util.Objects;

public class Advertisement {
    private int id;
    private int vehicleId;
    private int price;
    private String information;
    private String contactNumber;
    private Date dateOfPosting;

    public Advertisement() {}

    public Advertisement(int id, int vehicleId, int price, String information, String contactNumber, Date dateOfPosting) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.price = price;
        this.information = information;
        this.contactNumber = contactNumber;
        this.dateOfPosting = dateOfPosting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getDateOfPosting() {
        return dateOfPosting;
    }

    public void setDateOfPosting(Date dateOfPosting) {
        this.dateOfPosting = dateOfPosting;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", price=" + price +
                ", information='" + information + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", dateOfPosting=" + dateOfPosting +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertisement that = (Advertisement) o;
        return id == that.id &&
                vehicleId == that.vehicleId &&
                price == that.price &&
                Objects.equals(information, that.information) &&
                Objects.equals(contactNumber, that.contactNumber) &&
                Objects.equals(dateOfPosting, that.dateOfPosting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicleId, price, information, contactNumber, dateOfPosting);
    }

    public static class AdvertisementBuilder {
        private int id;
        private int vehicleId;
        private int price;
        private String information;
        private String contactNumber;
        private Date dateOfPosting;

        public AdvertisementBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public AdvertisementBuilder setVehicleId(int vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public AdvertisementBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public AdvertisementBuilder setInformation(String information) {
            this.information = information;
            return this;
        }

        public AdvertisementBuilder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public AdvertisementBuilder setDateOfPosting(Date dateOfPosting) {
            this.dateOfPosting = dateOfPosting;
            return this;
        }

        public Advertisement build() {
            return new Advertisement(id, vehicleId, price, information, contactNumber, dateOfPosting);
        }
    }
}