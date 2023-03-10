package commonsense.sort.applications;

import commonsense.sort.QuickSort;

import java.util.NoSuchElementException;

import static commonsense.sort.QuickSelect.ARRAY_MUST_CONTAIN_AT_LEAST_ONE_VALUE;
public class MissingNumber {

    public static final String NO_MISSING_ELEMENTS = "no missing elements";

    public static int findMissingNumber(int[] numbersToSearch) throws NoSuchElementException, IllegalArgumentException {
        if (numbersToSearch == null || numbersToSearch.length < 1) {
            throw new IllegalArgumentException(ARRAY_MUST_CONTAIN_AT_LEAST_ONE_VALUE);
        }
        final int[] sortedArray = new QuickSort(numbersToSearch).sort(0, numbersToSearch.length - 1);
        for (int i = 0; i < numbersToSearch.length; i++) {
            if (numbersToSearch[i] != i) {
                return i;
            }
        }
        throw new NoSuchElementException(NO_MISSING_ELEMENTS);
    }
}
