package commonsense.recursion;

import java.util.Arrays;

public class CountLetter {
    public static final String MINIMUM_INPUT_OF_ONE_NOT_MET = "minimum input of one not met";

    public static int countXs(String word) throws IllegalArgumentException {
        if (word == null || word.length() < 1) {
            throw new IllegalArgumentException(MINIMUM_INPUT_OF_ONE_NOT_MET);
        }
        return countXsRec(word.toCharArray());
    }

    public static int countXsRec(char[] word) {
        if (word.length == 1) {
            final Character c = Character.toLowerCase(word[0]);
            if (c.equals('x')) {
                return 1;
            } else {
                return 0;
            }
        }
        final Character c = Character.toLowerCase(word[0]);
        int count = 0;
        if (c.equals('x')) {
            count = 1;
        }
        return countXsRec(Arrays.copyOfRange(word, 1, word.length)) + count;
    }

}
