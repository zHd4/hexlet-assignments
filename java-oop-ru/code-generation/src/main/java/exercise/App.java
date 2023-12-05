package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path filePath, Car car) {
        try {
            Files.writeString(filePath, car.serialize(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path filePath) {
        try {
            return Car.unserialize(Files.readString(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
