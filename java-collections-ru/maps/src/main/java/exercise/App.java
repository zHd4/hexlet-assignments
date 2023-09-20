package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> result = new HashMap<>();

        if(sentence.isEmpty()) {
            return result;
        }

        String[] words = sentence.split(" ");

        for (String word : words) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }

        return result;
    }

    public static String toString(Map<String, Integer> wordsMap) {
        if(wordsMap.isEmpty()) {
            return "{}";
        }

        StringBuilder result = new StringBuilder("{\n");

        for (String word : wordsMap.keySet()) {
            result.append("  ").append(word).append(": ").append(wordsMap.get(word)).append("\n");
        }

        result.append("}");

        return result.toString();
    }
}
//END
