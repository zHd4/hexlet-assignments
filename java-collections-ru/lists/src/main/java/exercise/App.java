package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String letters, String word) {
        List<String> lettersList = new ArrayList<>(Arrays.asList(letters.toLowerCase().split("")));
        List<String> wordLetters = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));

        for (String wordLetter : wordLetters) {
            //noinspection RedundantCollectionOperation
            if (lettersList.contains(wordLetter)) {
                lettersList.remove(wordLetter);
            }
        }

        return letters.length() - lettersList.size() >= word.length();
    }
}
//END
