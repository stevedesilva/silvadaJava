package commonsense.optimise;

import java.util.List;

public class SumSwap {

    public int[] swapToMakeEqual(int[] a1, int[] a2) {
        validate(a1, a2);

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
