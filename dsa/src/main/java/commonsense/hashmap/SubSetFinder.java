package commonsense.hashmap;

import java.util.*;

public class SubSetFinder {

    public static final String MINIMUM_INPUT_REQUIRED = "minimum input required";

    public static int[] getSubsetFromArrays(int[] a1, int[] a2) throws IllegalArgumentException {
        validateInput(a1);
        validateInput(a2);
        List<Integer> result = new ArrayList<>();

        if ((a1 == null || a1.length < 1) && a2 != null && a2.length > 1) {
            return a2;
        }
        if ((a2 == null || a2.length < 1) && a1 != null && a1.length > 1) {
            return a1;
        }
        Set<Integer> res = new HashSet<>();
        int[] array;
        if (a1.length >= a2.length) {
            Arrays.stream(a1).forEach(i -> res.add(i));
            array = Arrays.stream(a2).filter((i) -> res.contains(i)).toArray();
        } else {
            Arrays.stream(a2).forEach(i -> res.add(i));
            array = Arrays.stream(a1).filter((i) -> res.contains(i)).toArray();
        }
        return array;
    }

    private static void validateInput(int[] array) {
        if (array == null || array.length < 1  ) {
            throw new IllegalArgumentException(MINIMUM_INPUT_REQUIRED);
        }
    }

}