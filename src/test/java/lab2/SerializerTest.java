package lab2;

import lab0.Variant8;
import lab1.Car;
import lab1.Vehicle;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class SerializerTest {

    @Test
    public void test() throws IOException {
        Vehicle vehicle = new Vehicle.VehicleBuilder().setBrand("Mercedes-Benz").setModel("C200").setYear(1997).build();

        // Приклад використання XmlSerializer
        XmlSerializer<Vehicle> xmlSerializer = new XmlSerializer<>(Vehicle.class);
        xmlSerializer.serialize(vehicle, Path.of("vehicle.xml"));
        Vehicle deserializeXml = xmlSerializer.deserialize(Path.of("vehicle.xml"));
        assertEquals(deserializeXml, vehicle);

        // Приклад використання JsonSerializer
        JsonSerializer<Vehicle> jsonSerializer = new JsonSerializer<>(Vehicle.class);
        jsonSerializer.serialize(vehicle, Path.of("vehicle.json"));
        Vehicle deserializeJson = jsonSerializer.deserialize(Path.of("vehicle.json"));
        assertEquals(deserializeJson, vehicle);

        // Приклад використання TxtSerializer
        TxtSerializer<Vehicle> txtSerializer = new TxtSerializer<>(Vehicle.class);
        txtSerializer.serialize(vehicle, Path.of("vehicle.txt"));
        Vehicle deserializeTxt = txtSerializer.deserialize(Path.of("vehicle.txt"));
        assertEquals(deserializeTxt, vehicle);
    }
}
