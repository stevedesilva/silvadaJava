package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.regex.Matcher;

class SumNumbersTest {
    @Test
    public void shouldThrowExceptionWhenMinimumInputNotMetEmptyArray() {
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SumNumbers.outerAndInnerValuesEqualHundred(new int[]{});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo("minimum of 2 values expected"));
    }
    @Test
    public void shouldThrowExceptionWhenMinimumInputNotMetOneValue() {
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SumNumbers.outerAndInnerValuesEqualHundred(new int[]{1});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo("minimum of 2 values expected"));
    }

    @ParameterizedTest
    @CsvSource(value = {"10,10:false","50,50:true"}, delimiter = ':')
    public void innerAndOuterValuesWorkingInwardsShouldEqual100(String inputString, boolean expected){
        int[] input = Arrays.stream(inputString.split(",")).mapToInt(Integer::parseInt).toArray();
        final boolean result = SumNumbers.outerAndInnerValuesEqualHundred(input);
        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }
}