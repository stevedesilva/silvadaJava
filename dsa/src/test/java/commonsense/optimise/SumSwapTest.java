package commonsense.optimise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SumSwapTest {

    @Test
    public void swapToMakeEqual() {
        SumSwap sumSwap = new SumSwap();
        int[] a1 = {4, 1, 2, 1, 1, 2};
        int[] a2 = {3, 6, 3, 3};
        final int[] result = sumSwap.swapToMakeEqual(a1, a2);
        assertArrayEquals(new int[]{1, 3}, result);
    }

    // create parameterised test for swapToMakeEqual
    @ParameterizedTest
    @CsvSource(value = {
            "'4,2,3,1', '4,2,5,3,6', '3,4'"
    })
    public void swapToMakeEqualParameterised(String a1, String a2, String expected) {
        SumSwap sumSwap = new SumSwap();
        int[] a1Array = convertStringToIntArray(a1);
        int[] a2Array = convertStringToIntArray(a2);
        int[] expectedArray = convertStringToIntArray(expected);
        final int[] result = sumSwap.swapToMakeEqual(a1Array, a2Array);
        assertArrayEquals(expectedArray, result);
    }

    private int[] convertStringToIntArray(String a1) {
        String[] split = a1.split(",");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

}