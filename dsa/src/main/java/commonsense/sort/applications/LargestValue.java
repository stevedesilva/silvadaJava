package commonsense.sort.applications;

import commonsense.sort.QuickSort;

import java.util.Arrays;

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
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            boolean isLargest = true;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[j] > max) {
                    max = numbers[j];
                    isLargest = false;
                }
            }
            if (isLargest) {
                break;
            }
        }
        return max;
    }

    public static Integer findLargestValueNLogN(Integer[] numbers) {
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("numbers array must contain at least one value");
        }
        final int[] ints = Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();
        final int[] sortedArray = QuickSort.sortedArray(ints);
        return sortedArray[numbers.length - 1];
    }
}
