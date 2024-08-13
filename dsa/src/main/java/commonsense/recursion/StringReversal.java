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


    public static String[] reverseArrayInline2(String[] words) {
        int i = 0;
        int j = words.length - 1;

        while (i < j ){
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        return words;
    }

    public static String[] reverseArrayInline(String[] words) {
        if (words.length < 2) {
            return words;
        }
        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }
        return words;
    }



}
