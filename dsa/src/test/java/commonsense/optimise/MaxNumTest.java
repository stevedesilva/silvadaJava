package commonsense.optimise;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MaxNumTest {

    // throw IllegalArgumentException if array is null or empty
    @Test
    public void maxNumNullArrayTest() {
        MaxNum maxNum = new MaxNum();
        assertThrows(IllegalArgumentException.class, () -> maxNum.maxNum(null));
        assertThrows(IllegalArgumentException.class, () -> maxNum.maxNum(new int[]{}));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'3,-1,1',3",
            "'1,1,-2,5',5",
            "'-1,1,1,1',1",
            "'-10,1,7,-9,1',7",
            "'7,7",
    })
    public void maxNumTest(String a1, int expected) {
        MaxNum maxNum = new MaxNum();
        int[] array = convertStringToIntArray(a1);
        final int result = maxNum.maxNum(array);
        MatcherAssert.assertThat(result, org.hamcrest.Matchers.is(expected));

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