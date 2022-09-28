package commonsense.array;

public class SumNumbers {
    public static boolean outerAndInnerValuesEqualHundred(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("minimum of 2 values expected");
        }
        for (int i = 0, j = array.length - 1; i < j; i++,j--) {
            if (array[i] + array[j] == 100) {
                return true;
            }
        }
        return false;
    }
}

