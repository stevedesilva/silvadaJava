package commonsense.optimise;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MaxSumTest {
    @ParameterizedTest
    @CsvSource(value = {
            "'3,-1,1',3",
            "'1,1,-2,5',5",
            "'-1,1,1,1',3",
    })
    public void maxSumParameterised(String a1, int expected) {
        MaxSum maxSum = new MaxSum();
        int[] a1Array = convertStringToIntArray(a1);
        final int result = maxSum.findMaxSumInArray(a1Array);
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