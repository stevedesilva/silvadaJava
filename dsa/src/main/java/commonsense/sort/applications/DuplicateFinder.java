package commonsense.sort.applications;

import commonsense.sort.QuickSort;

import static commonsense.sort.QuickSelect.ARRAY_MUST_CONTAIN_AT_LEAST_ONE_VALUE;

public class DuplicateFinder {

    public boolean hasDuplicates(int[] array) {
        if (array.length < 1) {
            throw new IllegalArgumentException(ARRAY_MUST_CONTAIN_AT_LEAST_ONE_VALUE);
        }

        final int[] sorted = new QuickSort(array).sort(0, array.length-1);
        for (int i = 0; i < array.length - 1; i++){
           if(sorted[i] == sorted[i + 1]) {
               return true;
           }
        }
        return false;
    }

}
