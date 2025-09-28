package commonsense.optimise;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LongestSequenceTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1:1",
            "1,2:1,2",
            "1,2,3:1,2,3"
    }, delimiter = ':')
    public void TestLongestSequence(String input, String output) {
        final int[] numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        final int[] result = LongestSequence.findLongestConsecutiveSequence(numbers);
        MatcherAssert.assertThat(result, Matchers.equalTo(numbers));
    }
}