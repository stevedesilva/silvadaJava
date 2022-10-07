package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class LargestProductTest {
    @Test
    public void shouldThrowExceptionWhen() {
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                LargestProduct.findLargestProduct(new int[]{})
        );
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo(LargestProduct.MINIMUM_OF_3_VALUES_REQUIRED));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6","1,2,3,4:24","5,5,3,4,5:125","1,2,3,4,5:60"}, delimiter = ':')
    public void shouldReturnLargestProduct(String input, int expected) {
        final int[] array = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        MatcherAssert.assertThat(LargestProduct.findLargestProduct(array), Matchers.equalTo(expected));
    }
}