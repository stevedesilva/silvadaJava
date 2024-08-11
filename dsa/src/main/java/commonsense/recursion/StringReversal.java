package commonsense.recursion;

import java.util.Arrays;

public class StringReversal {
    public static final String MINIMUM_INPUT_OF_ONE_NOT_MET = "minimum input of one not met";

    public static String reverse(String word) throws IllegalArgumentException {
        if (word == null || word.length() < 1) {
            throw new IllegalArgumentException(MINIMUM_INPUT_OF_ONE_NOT_MET);
        }
        return reverseRec(word.toCharArray());
    }

    public static String reverseRec(char[] word) {
        if (word.length == 1) {
            return "" + word[0];
        }
        return reverseRec(Arrays.copyOfRange(word, 1, word.length)) + word[0];
    }

    public static String[] reverseArrayInline(String[] words) {

        return words;
    }


}
