package commonsense.hashmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class DuplicateFinder {
    public static final String MINIMUM_INPUT_REQUIRED = "minimum input required";
    public static final String NO_DUPLICATE_FOUND = "no duplicate found";

    public static String findFirstDuplicate(String[] in) throws IllegalArgumentException, NoSuchElementException {
        if(in == null || in.length < 2) {
            throw new IllegalArgumentException(MINIMUM_INPUT_REQUIRED);
        }
        Set<String> values = new HashSet<>();
        for(String v: in){
            if(values.contains(v)) {
                return v;
            }
            values.add(v);
        }
        throw new NoSuchElementException(NO_DUPLICATE_FOUND);
    }
}
