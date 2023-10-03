package exercise;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> mans) {
        return mans.stream()
                .filter(human -> human.get("gender").equals("male"))
                .sorted((man1, man2) -> {
                    LocalDate date1 = LocalDate.parse(man1.get("birthday"));
                    LocalDate date2 = LocalDate.parse(man2.get("birthday"));
                    return date1.compareTo(date2);
                })
                .map(man -> man.get("name"))
                .collect(Collectors.toList());
    }
}
// END
