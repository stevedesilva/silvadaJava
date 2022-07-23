package commonsense.search;

import java.util.Optional;

public class LinearSearch<T> {
    public LinearSearch() {
    }

    public Optional<Integer> search(T[] array, T value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }


}
