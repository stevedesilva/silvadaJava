package commonsense.array;

public class SumNumbers {
    public static boolean outerAndInnerValuesEqualHundred(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("minimum of 2 values expected");
        }

        return false;
    }
}
