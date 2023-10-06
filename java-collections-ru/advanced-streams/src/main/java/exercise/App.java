package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String getForwardedVariables(String configData) {
        return String.join("," ,Arrays.stream(configData.split("\n"))
                .filter(line -> line.startsWith("environment="))
                .map(line -> line.replace("environment=", ""))
                .map(line -> line.replace("\"", ""))
                .flatMap(line -> Stream.of(line.split(",")))
                .filter(variable -> !variable.isBlank())
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.replace("X_FORWARDED_" , ""))
                .toList());
    }
}
//END
