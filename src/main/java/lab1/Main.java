package lab1;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        Model model = new Model.ModelBuilder()
                        .setBrand(new Brand.BrandBuilder().setName("Opel").build())
                        .setName("Zafira").build();

        Model model1 = new Model.ModelBuilder()
                        .setBrand(new Brand.BrandBuilder().setName("Mercedes-Benz").build())
                        .setName("C200").build();

        Vehicle v = new Vehicle.VehicleBuilder()
                        .setModel(model)
                        .setYear(2013).build();

        Vehicle v1 = new Vehicle.VehicleBuilder()
                        .setModel(model1)
                        .setYear(1997).build();

        Advertisement a = new Advertisement.AdvertisementBuilder()
                        .setVehicle(v)
                        .setPrice(8000)
                        .setInformation("Не бита, не крашена, любі форми переоформлення, торг біля капота")
                        .setContactNumber("+380689845632")
                        .setDateOfPosting(LocalDate.of(2023, 12, 10)).build();

        Advertisement a1 = new Advertisement.AdvertisementBuilder()
                        .setVehicle(v1)
                        .setPrice(4000)
                        .setInformation("Ходова в гарному стані, мотор масло не бере, кондиціонер заправлений. Тільки переоформлення")
                        .setContactNumber("+380667690922")
                        .setDateOfPosting(LocalDate.now()).build();

        AutoMarket autoMarket = new AutoMarket(List.of(a, a1));

        autoMarket.getAdvertisements().forEach(System.out::println);
    }
}
