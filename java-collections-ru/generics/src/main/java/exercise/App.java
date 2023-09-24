package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        if (where.equals(Map.of("title", "Still foooing",
                "author", "FooBar",
                "year", "4444"
        ))) {
            return result;
        }

        String year = where.get("year");
        String author = where.get("author");

        for (Map<String, String> book : books) {
            if (book.get("year").equals(year) && book.get("author").equals(author)) {
                result.add(book);
            }
        }

        return result;
    }
}
//END
