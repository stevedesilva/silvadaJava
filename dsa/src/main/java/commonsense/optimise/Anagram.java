package commonsense.optimise;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean isAnagram(String firstString, String secondString) {
        // Check for null or empty strings
        if (firstString == null || secondString == null || firstString.isEmpty() || secondString.isEmpty()) {
            throw new IllegalArgumentException("Strings must not be null or empty");
        }

        Map<Character,Integer> firstStringMap = new HashMap<>();
        Map<Character,Integer> secondStringMap = new HashMap<>();

        return false;
    }
}
