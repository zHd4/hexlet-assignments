package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        if (apartments.isEmpty()) {
            return new ArrayList<>();
        }

        return new ArrayList<>(apartments.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .map(Home::toString)
                .toList()).subList(0, count);
    }
}
// END
