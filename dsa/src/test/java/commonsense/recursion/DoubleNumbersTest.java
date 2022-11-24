package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class DoubleNumbersTest {
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"1,2,3:2,4,6","1,2,3,4,5:2,4,6,8,10"})
    public void shouldDoubleNumbersInArray(String inputArrayAsString, String outputArrayAsString) {
        final int[] input = Arrays.stream(inputArrayAsString.split(",")).mapToInt(Integer::valueOf).toArray();
        final int[] want = Arrays.stream(outputArrayAsString.split(",")).mapToInt(Integer::valueOf).toArray();
        int[] got = DoubleNumbers.doubleNumbers(input);
        MatcherAssert.assertThat(got, Matchers.equalTo(want));
    }

}