package lab5.models;

import java.util.List;
import java.util.Objects;

public class AutoMarket {
    private List<Advertisement> advertisements;

    public AutoMarket() {}

    public AutoMarket(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public String toString() {
        return "AutoMarket{" +
                "advertisements=" + advertisements +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoMarket that = (AutoMarket) o;
        return Objects.equals(advertisements, that.advertisements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(advertisements);
    }

    public static class AutoMarketBuilder {
        private List<Advertisement> advertisements;

        public AutoMarketBuilder setAdvertisements(List<Advertisement> advertisements) {
            this.advertisements = advertisements;
            return this;
        }

        public AutoMarket build() {
            return new AutoMarket(advertisements);
        }
    }
}