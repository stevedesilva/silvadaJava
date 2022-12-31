package commonsense.recursion;

import java.util.Arrays;

public class FindIndex {
    public static int findFirstIndex(String word, char toFind) throws IllegalArgumentException {
        return findFirstIndexRec(word, toFind, 0);
    }

    public static int findFirstIndexRec(String word, char toFind, int index) {
        if (word.length() == index) {
            throw new IllegalArgumentException("Not found");
        }
        if (word.charAt(index) == toFind) {
            return index;
        }
        return findFirstIndexRec(word, toFind, index + 1);
    }

    public static int findFirstIndexAlt(String word, char toFind) throws IllegalArgumentException {
        return findFirstIndexRecAlt(word.toCharArray(), toFind);
    }

    public static int findFirstIndexRecAlt(char[] word, char toFind) {
        if (word.length == 0) {
            throw new IllegalArgumentException("Not found");
        }
        if (word[0] == toFind) {
            return 0;
        }
        return findFirstIndexRecAlt(Arrays.copyOfRange(word,1,word.length), toFind) + 1;
    }
}
