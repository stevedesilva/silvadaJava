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

        for (char c : firstString.toCharArray()) {
            if (firstStringMap.containsKey(c)) {
                firstStringMap.put(c, firstStringMap.get(c) + 1);
            } else {
                firstStringMap.put(c,1);
            }
        }
        for (char c : secondString.toCharArray()) {
            if (secondStringMap.containsKey(c)) {
                secondStringMap.put(c, secondStringMap.get(c) + 1);
            } else {
                secondStringMap.put(c,1);
            }
        }

        // compare the two maps
        return firstStringMap.equals(secondStringMap);
    }
}
