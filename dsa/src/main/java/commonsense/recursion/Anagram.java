package commonsense.recursion;

import java.util.ArrayList;
import java.util.List;

public class Anagram {

    public static List<String> findAllPossibleAnagrams(String word) {
        List<String> allPossibleAnagrams = new ArrayList<>();
        // base case
        if (word == null || word.length() <= 1) {
            // base case is a single char string
             allPossibleAnagrams.add(word);
             return allPossibleAnagrams;
        }
        // find sub anagrams
        Character firstChar = word.charAt(0);
        String subString = word.substring(1);
        List<String> subAnagrams = findAllPossibleAnagrams(subString);

        // for each anagram find all possible combos
        subAnagrams.forEach( anagram -> {
            for (int i = 0; i <= anagram.length(); i++) {
                var before = anagram.substring(0,i) ;
                var after = anagram.substring(i);
                StringBuilder sb = new StringBuilder();
                sb.append(before).append(firstChar).append(after);
                allPossibleAnagrams.add(sb.toString());
            }
        });
        return allPossibleAnagrams;
    }

}
