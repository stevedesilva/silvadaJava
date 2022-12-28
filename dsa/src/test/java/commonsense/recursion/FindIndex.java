package commonsense.recursion;

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

}
