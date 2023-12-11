package lab1;

import java.util.List;
import java.util.Objects;

/**
 * The {@code AutoMarket} class represents a marketplace for advertisements of vehicles. It contains a list
 * of {@code Advertisement} objects and provides methods to retrieve, set, and build instances of the class.
 */
public class AutoMarket {
    /** The list of advertisements in the auto market. */
    private List<Advertisement> advertisements;

    /**
     * Constructs a new {@code AutoMarket} object with an empty list of advertisements.
     */
    public AutoMarket() {}

    /**
     * Constructs a new {@code AutoMarket} object with the specified list of advertisements.
     *
     * @param advertisements the list of advertisements in the auto market.
     */
    public AutoMarket(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    /**
     * Gets the list of advertisements in the auto market.
     *
     * @return the list of advertisements.
     */
    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    /**
     * Sets the list of advertisements in the auto market.
     *
     * @param advertisements the new list of advertisements.
     */
    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    /**
     * Returns a string representation of the {@code AutoMarket} object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "AutoMarket{" +
                "advertisements=" + advertisements +
                '}';
    }

    /**
     * Indicates whether some other object is "equal to" this one. Equality is based on the equality of
     * the list of advertisements.
     *
     * @param o the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoMarket that = (AutoMarket) o;
        return Objects.equals(advertisements, that.advertisements);
    }

    /**
     * Returns a hash code value for the {@code AutoMarket} object based on the hash code of the list of advertisements.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(advertisements);
    }

    /**
     * The {@code AutoMarketBuilder} class is a builder for creating {@code AutoMarket} objects.
     */
    public static class AutoMarketBuilder {
        /** The list of advertisements in the auto market. */
        private List<Advertisement> advertisements;

        /**
         * Sets the list of advertisements for the auto market.
         *
         * @param advertisements the list of advertisements.
         */
        public AutoMarketBuilder setAdvertisements(List<Advertisement> advertisements) {
            this.advertisements = advertisements;
            return this;
        }

        /**
         * Builds a new {@code AutoMarket} object with the specified parameters.
         *
         * @return a new {@code AutoMarket} object.
         */
        public AutoMarket build() {
            return new AutoMarket(advertisements);
        }
    }
}