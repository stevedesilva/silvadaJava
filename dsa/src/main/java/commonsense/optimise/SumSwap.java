package commonsense.optimise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumSwap {

    public int[] swapToMakeEqual(int[] a1, int[] a2) {
        validate(a1, a2);
        // key
        Map<Integer, Integer> a1Map = new HashMap<>();
        // get a sum of a1 while storing it's values in hashmap
        int a1Total = 0;
        for (int index = 0; index < a1.length; index++) {
            final int number = a1[index];
            a1Total += number;
            a1Map.put(number, index);
        }

        final int a2Total = Arrays.stream(a2).sum();

        // calculate the difference between the two arrays
        final int difference = (a1Total - a2Total) / 2;

        for (int i=0; i < a2.length; i++) {
            // check map for the numbers counterpart in the 1st array,
            // which is calculated as the current number
            // plus the amount it has to shift by:
            final int num = a2[i];
            final int numToFind = num + difference;
            try {
                if (a1Map.containsKey(numToFind)) {
//                    return new int[]{a1[numToFind],i};
                    return new int[]{a1Map.get(numToFind),i};
                }
            } catch (Exception e) {
                // continue
            }

        }
        // throw item not found exception
        throw new IllegalArgumentException("no items found");

    }

    private void validate(int[] a1, int[] a2) {
        // validation
        if (a1 == null || a2 == null) {
            throw new IllegalArgumentException("input arrays cannot be null");
        }
        if (a1.length == 0 || a2.length == 0) {
            throw new IllegalArgumentException("input arrays cannot be empty");
        }

    }
}
