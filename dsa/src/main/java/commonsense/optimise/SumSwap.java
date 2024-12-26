package commonsense.optimise;

import java.util.List;

public class SumSwap {

    public int[] swapToMakeEqual(int[] a1, int[] a2) {
        validate(a1, a2);
        // 1 - larger array needs to trade a larger number with a smaller number from the smaller array
        // 2 - with a single swap, each array sum changes by the same amount  (e.g. given 7,4 increases by 3, decreases by 3)
        // 3 - swaps cause the 2 array sums to fall out exactly in the middle of where the two arrays sums began (e.g. 18, 12 -> 15)
        // Therefore if we know the sums of the 2 arrays, we should be able to look at any number in one of the arrays and calculate what number it should be swapped with in the other array
        return null;
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
