package dsa.section6;

import java.util.HashMap;
import java.util.Map;

public class MaxCharacter {

    public String getMaxWithCharMap(String input) {
        input = input.replaceAll("\\s+", "");
        Map<Character, Integer> charMap = new HashMap<>();

        int max = -1;
        Character maxChar = null;

        for (int i = 0; i < input.length(); i++) {
            char key = input.charAt(i);
            Integer value;
            if (charMap.containsKey(key)) {
                value = charMap.get(key) + 1;
                charMap.put(key, value);
            } else {
                value = Integer.valueOf(1);
                charMap.put(key, 1);
            }
            // update max values
            if (value > max) {
                max = value;
                maxChar = key;
            }
        }
        return String.valueOf(maxChar);
    }

    public String getMaxWithCharArray(String input) {
        // remove string
        input = input.replaceAll("\\s+", "");
        int[] inChars = new int[256];
        int max = -1;
        int maxChar = -1;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            inChars[currentChar]++;

            if (inChars[currentChar] > max) {
                max = inChars[currentChar];
                maxChar = currentChar;
            }
        }
        char inToChar = (char) maxChar;
        return String.valueOf(inToChar);
    }
}
