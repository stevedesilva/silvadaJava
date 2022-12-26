package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CountEvenNumbersTest {
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
//           "1:",
//           "2:2",
    })
    public void shouldReturnEvenNumbersFromArray(String input, String expected) {
        final List<Integer> want = Arrays.stream(expected.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> got = CountEvenNumbers.countEvenNumbers(Arrays.stream(input.split(",")).mapToInt(Integer::valueOf).toArray());
        MatcherAssert.assertThat(got, Matchers.equalTo(want));
    }
}