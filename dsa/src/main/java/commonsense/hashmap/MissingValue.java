package commonsense.hashmap;

import java.util.Set;
import java.util.stream.Collectors;

public class MissingValue {
    public static String findFirstMissingCharacter(String sentence)  {
        final Set<Character> sentenceSet = sentence.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        String missing = "";
        Character curr = 'a';
        while (curr <= 'z') {
            if (!sentenceSet.contains(curr)) {
                missing = curr.toString();
                break;
            }
            curr++;
        }

        return missing;
    }
}
