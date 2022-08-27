package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MeanNumbersTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:2.0","2,2,2:2.0","12,12,6:10.0"},delimiter = ':')
    public void shouldReturnMeanFromEvenNumbers(String input, float result) {
        final int[] ints = Arrays.stream(input.split(",")).mapToInt(t -> Integer.parseInt(t)).toArray();
        MatcherAssert.assertThat(MeanNumbers.getMeanFromEvenNumbers(ints), Matchers.equalTo(result));
    }

    @Test
    public void shouldThrowExceptionWhenNoEvenNumber() {
        int[] ints = new int[]{1,3,5,7};
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MeanNumbers.getMeanFromEvenNumbers(ints);
        });
        MatcherAssert.assertThat(exception.getClass(), Matchers.equalTo(IllegalArgumentException.class));
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo("No even numbers found"));
    }

}