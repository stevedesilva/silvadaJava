package commonsense.recursion.dynamic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AddNumberTest {
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"1:1", "1,2,3,4:10", "1,2,3,4,20,30,15:75","1,2,3,4,20,30,15,25:100"})
    public void shouldAddUntil100(String input, int expected) {
        int[] numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        MatcherAssert.assertThat(AddNumber.addUntilOneHundred(numbers), Matchers.equalTo(expected));
    }
}