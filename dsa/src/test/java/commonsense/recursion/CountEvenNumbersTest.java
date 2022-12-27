package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CountEvenNumbersTest {
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "1:",
            "1,3,5,7,9:",
            "2:2",
            "2,4,6,8,10:2,4,6,8,10",
            "1,2,3,4,5,6,7,8,9,10:2,4,6,8,10",
    })
    public void shouldReturnEvenNumbersFromArray(String input, String expected) {
        List<Integer> want;
        if (expected == null) {
            want = new ArrayList<>();
            ;
        } else {
            want = Arrays.stream(expected.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        }
        List<Integer> got = CountEvenNumbers.countEvenNumbers(Arrays.stream(input.split(",")).mapToInt(Integer::valueOf).toArray());
        MatcherAssert.assertThat(got, Matchers.equalTo(want));
    }
}