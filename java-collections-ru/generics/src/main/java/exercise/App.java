package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : books) {
            boolean wasFound = true;

            for (Entry<String, String> param : where.entrySet()) {
                String bookParamValue = book.getOrDefault(param.getKey(), "");

                if (!param.getValue().equals(bookParamValue)) {
                    wasFound = false;

                    break;
                }
            }

            if (wasFound) {
                result.add(book);
            }
        }

        return result;
    }
}
//END
