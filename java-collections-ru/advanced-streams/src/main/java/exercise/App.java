package exercise;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String configData) {
        List<String> environmentLines = Arrays.stream(configData.split("\n"))
                .filter(line -> line.startsWith("environment="))
                .map(line -> line.replace("environment=", ""))
                .map(line -> line.replace("\"", ""))
                .toList();

        Function<String, String> getKey = variable -> variable.split("=")[0]
                .replace("X_FORWARDED_", "");

        Function<String, String> getValue = variable -> variable.split("=")[1];

        Map<String, String> variables = environmentLines.stream()
                .flatMap(line -> Stream.of(line.split(",")))
                .filter(variable -> !variable.isBlank())
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .collect(Collectors.toMap(getKey, getValue));

        List<String> result = variables.keySet().stream()
                .map(key -> key + "=" + variables.get(key))
                .toList();

        return String.join(",", result);
    }
}
//END
