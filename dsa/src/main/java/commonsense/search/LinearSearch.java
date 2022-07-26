package commonsense.search;

import java.util.Comparator;
import java.util.Optional;

public class LinearSearch<T extends Comparable<T>> {
    public LinearSearch() {
    }

    public Optional<Integer> searchUnsorted(T[] array, T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
    // 0 1 2 3
    // A B C D
    public Optional<Integer> searchSorted(T[] array, T valueToFind) {
        for (int i = 0; i < array.length; i++) {
            final T currentValue = array[i];
            if (currentValue.equals(valueToFind)) {
                return Optional.of(i);
            }
            if (currentValue.compareTo(valueToFind) > 0) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
