package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;



class SampleTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:1,2,3","1:1,1,1"}, delimiter = ':')
    public void shouldReturnSample(String input, String output) {
        final int[] inputAsInts = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        final int[] outputAsInts = Arrays.stream(output.split(",")).mapToInt(Integer::parseInt).toArray();
        final Sample.Result actual = Sample.getStartMiddleEndElements(inputAsInts);
        Sample.Result result = new Sample.Result(outputAsInts[0],outputAsInts[1],outputAsInts[2]);
        MatcherAssert.assertThat(actual, Matchers.equalTo(result));
    }
    @Test
    public void shouldThrowExceptionWhenLessThanOneInputItem() {
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Sample.getStartMiddleEndElements(new int[]{});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo("need at least one value in array"));
    }
}