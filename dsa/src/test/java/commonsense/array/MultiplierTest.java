package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class MultiplierTest {
    @ParameterizedTest
    @CsvSource(value = {"1,:1", "1,2:2"}, delimiter = ':')
    public void shouldProduceMultiplesOfInputArray(String input, String output) {
        final int[] inputArray = getIntArrayFromString(input);
        final int[] result = Multiplier.findTheProduct(inputArray);
        final int[] expected = getIntArrayFromString(output);
        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }

    @Test
    public void throwsExceptionWhenMinimumInputNotMet() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Multiplier.findTheProduct(new int[]{1});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo("a minimum input of 2 numbers is required"));

        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Multiplier.findTheProduct(new int[]{});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo("a minimum input of 2 numbers is required"));
    }

    private int[] getIntArrayFromString(String input) {
        final String[] split = input.split(",");
        final int[] inputArray = Arrays.stream(split).mapToInt(s -> Integer.parseInt(s)).toArray();
        return inputArray;
    }
}