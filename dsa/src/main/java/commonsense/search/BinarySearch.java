package commonsense.search;

import java.util.Optional;

public class BinarySearch {
    public Optional<Integer> findInSortedArray(int valueToFind, int[] array) {
        int upper = array.length - 1;
        int lower = 0;
        while (lower <= upper) {
            int mid = (upper + lower) / 2;
            final int midValue = array[mid];
            if (valueToFind == midValue) {
                return Optional.of(mid);
            } else if (valueToFind < midValue) {
                upper = mid - 1;
            } else if (valueToFind > midValue) {
                lower = mid + 1;
            }
        }
        return Optional.empty();
    }
}
