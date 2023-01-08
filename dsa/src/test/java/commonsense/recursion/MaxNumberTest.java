package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;


class MaxNumberTest {
    @ParameterizedTest
    @CsvSource(value = {":1","1:1", "1,2,3,4:4", "5,1,2,3,4:5"}, delimiter = ':')
    public void shouldReturnMaxNumber(String input, int expected) {
        if(input == null) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                MaxNumber.findMaxNumber(new int[]{});
            });
        } else {

            int[] in = Arrays.stream(input.split(",")).mapToInt(i -> Integer.parseInt(i)).toArray();
            MatcherAssert.assertThat(MaxNumber.findMaxNumber(in), Matchers.equalTo(expected));
        }

    }
}