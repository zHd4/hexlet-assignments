package exercise;

import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();

        for (Map.Entry<String, Object> entry1 : map1.entrySet()) {
            if (!map2.containsKey(entry1.getKey())) {
                result.put(entry1.getKey(), "deleted");
            } else {
                boolean wasChangedValue = entry1.getValue().equals(map2.get(entry1.getKey()));

                result.put(entry1.getKey(), wasChangedValue ? "unchanged" : "changed");
            }
        }

        for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
            if (!map1.containsKey(entry2.getKey())) {
                result.put(entry2.getKey(), "added");
            }
        }

        return result;
    }
}
//END
