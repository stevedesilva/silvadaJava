package commonsense.array;

public class NumberCount {
    static public int countTheOnes(int[][] array) throws IllegalArgumentException {
        if (array == null || array.length <= 0) {
            throw new IllegalArgumentException("input array is mandatory");
        }
        return 0;
    }
}
