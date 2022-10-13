package commonsense.hashmap;

import java.util.NoSuchElementException;

public class DuplicateFinder {
    public static final String MINIMUM_INPUT_REQUIRED = "minimum input required";
    public static final String NO_DUPLICATE_FOUND = "no duplicate found";

    public static String findFirstDuplicate(String[] in) throws IllegalArgumentException, NoSuchElementException {
        if(in == null || in.length < 2) {
            throw new IllegalArgumentException(MINIMUM_INPUT_REQUIRED);
        }
        throw new NoSuchElementException(NO_DUPLICATE_FOUND);
    }
}
