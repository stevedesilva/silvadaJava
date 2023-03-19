package commonsense.sort.applications;

import jdk.jshell.spi.ExecutionControl;

public class LargestValue {

    public static Integer findLargestValueN(Integer[] numbers) {
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("numbers array must contain at least one value");
        }
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static Integer findLargestValueN2(Integer[] numbers) {
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("numbers array must contain at least one value");
        }
        throw new UnsupportedOperationException();
    }

    public static Integer findLargestValueNLogN(Integer[] numbers) {
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("numbers array must contain at least one value");
        }
        throw new UnsupportedOperationException();
    }
}
