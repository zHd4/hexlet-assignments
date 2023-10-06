package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String configData) {
        List<String> environmentLines = Arrays.stream(configData.split("\n"))
                .filter(line -> line.startsWith("environment="))
                .map(line -> line.replace("environment=", ""))
                .map(line -> line.replace("\"", ""))
                .toList();

        List<String> variables = environmentLines.stream()
                .flatMap(line -> Stream.of(line.split(",")))
                .filter(variable -> !variable.isBlank())
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .toList();

        List<String> result = variables.stream()
                .map(variable -> variable.replace("X_FORWARDED_" , ""))
                .toList();

        return String.join(",", result);
    }
}
//END
