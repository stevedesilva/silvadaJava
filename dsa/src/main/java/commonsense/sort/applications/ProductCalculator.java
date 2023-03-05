package commonsense.sort.applications;

import commonsense.sort.QuickSort;

import static commonsense.sort.QuickSelect.ARRAY_MUST_CONTAIN_AT_LEAST_ONE_VALUE;

public class ProductCalculator {

    public static final String RANGE_IS_GREATER_THAN_ARRAY_LENGTH = "range is greater than array length";

    public int findGreatestProductForNumbers(int[] array, int numberRange) throws IllegalArgumentException {
        if (array.length < 1) {
            throw new IllegalArgumentException(ARRAY_MUST_CONTAIN_AT_LEAST_ONE_VALUE);
        }
        if (array.length < numberRange) {
            throw new IllegalArgumentException(RANGE_IS_GREATER_THAN_ARRAY_LENGTH);
        }

        final int[] sorted = new QuickSort(array).sort(0, array.length - 1);
        int sum = 0;
        int count = 0;
        while (count < numberRange) {
            final int last = array.length - 1;
            sum += sorted[last - count];
            count++;
        }
        return sum;
    }
}
