package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class LargestProductTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:6","1,2,3,4:24",}, delimiter = ':')
    public void shouldReturnLargestProduct(String input, int expected) {
        final int[] array = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        MatcherAssert.assertThat(LargestProduct.findLargestProduct(array), Matchers.equalTo(expected));
    }

}