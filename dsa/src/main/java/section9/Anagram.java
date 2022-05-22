package section9;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static boolean execute(String inputA, String inputB) {
        if (inputA == null || inputB == null){
            return false;
        }
        // remove all none chars
        // can used [^\w] or \\W
        String wordA = inputA.replaceAll("[^\\w]","").toLowerCase();
        String wordB = inputB.replaceAll("\\W","").toLowerCase();
        // compare length of section5string
        if (wordA.length() != wordB.length()) {
            return false;
        }

        // add to a map keyed on lower case char
        Map<Character, Integer> wordMapA = convertStringToCharacterMap(wordA);
        Map<Character, Integer> wordMapB = convertStringToCharacterMap(wordB);

        // compare maps
        return wordMapA.equals(wordMapB);
    }

    private static Map<Character, Integer> convertStringToCharacterMap(String word) {
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            if (characterCountMap.containsKey(key)) {
                characterCountMap.put(key,characterCountMap.get(key).intValue() + 1);
            } else {
                characterCountMap.put(key,1);
            }
        }
        return characterCountMap;
    }
}
