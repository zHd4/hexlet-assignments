package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage database) {
        database.toMap().forEach((key, value) -> {
            database.unset(key);
            database.set(value, key);
        });
    }
}
// END
