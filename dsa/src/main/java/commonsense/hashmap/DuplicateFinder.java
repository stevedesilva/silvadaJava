package commonsense.hashmap;

import java.util.*;

public class DuplicateFinder {
    public static final String MINIMUM_INPUT_REQUIRED = "minimum input required";
    public static final String NO_DUPLICATE_FOUND = "no duplicate found";
    public static final String NON_DUPLICATE_FOUND = "no duplicate found";

    public static String findFirstDuplicate(String[] in) throws IllegalArgumentException, NoSuchElementException {
        validateInput(in);
        Set<String> values = new HashSet<>();
        for(String v: in){
            if(values.contains(v)) {
                return v;
            }
            values.add(v);
        }
        throw new NoSuchElementException(NO_DUPLICATE_FOUND);
    }

    public static String findFirstNonDuplicate(String[] in) throws IllegalArgumentException, NoSuchElementException {
        validateInput(in);

        Map<String,Integer> values = new HashMap<>();
        for(String v: in){
            values.compute(v, (k,val) -> val == null ? 1 : val + 1);
        }
        for(String v: in){
            if (values.get(v) == 1) {
                return v;
            }
        }
        throw new NoSuchElementException(NON_DUPLICATE_FOUND);
    }

    private static void validateInput(String[] in) throws IllegalArgumentException {
        if (in == null || in.length < 2) {
            throw new IllegalArgumentException(MINIMUM_INPUT_REQUIRED);
        }
    }
}
