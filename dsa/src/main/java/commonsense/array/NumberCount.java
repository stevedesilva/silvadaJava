package commonsense.array;

public class NumberCount {
    static public int countTheOnes(int[][] array) throws IllegalArgumentException {
        if (array == null || array.length <= 0) {
            throw new IllegalArgumentException("input array is mandatory");
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
