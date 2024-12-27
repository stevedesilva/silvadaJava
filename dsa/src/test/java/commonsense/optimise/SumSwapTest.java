package commonsense.optimise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SumSwapTest {


    @Test
    public void swapToMakeEqual1() {
        SumSwap sumSwap = new SumSwap();
        int[] a1 = {5, 3, 2, 9, 1}; // 20
        int[] a2 = {1, 12, 5}; // 18
        final int[] result = sumSwap.swapToMakeEqual(a1, a2); // 2, 0
        assertArrayEquals(new int[]{2, 0}, result);
    }


    @Test
    public void swapToMakeEqual2() {
        SumSwap sumSwap = new SumSwap();
        int[] a1 = {5, 3, 3, 7}; // 18
        int[] a2 = {4, 1, 1, 6}; // 12
        final int[] result = sumSwap.swapToMakeEqual(a1, a2); // 3, 0
        assertArrayEquals(new int[]{3, 0}, result);
    }

    @Test
    public void swapToMakeEqual3() {
        SumSwap sumSwap = new SumSwap();
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {6, 7, 8};
        final int[] result = sumSwap.swapToMakeEqual(a1, a2);
        assertArrayEquals(new int[]{2, 0}, result);
    }

    @Test
    public void swapToMakeEqual4() {
        SumSwap sumSwap = new SumSwap();
        int[] a1 = {10, 15, 20};
        int[] a2 = {5, 30};
        final int[] result = sumSwap.swapToMakeEqual(a1, a2);
        assertArrayEquals(new int[]{0, 0}, result);
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