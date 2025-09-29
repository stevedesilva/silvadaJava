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
            "1,2,3:1,2,3",
            "1,2,4,5:4,5",
            "10,5,12,3,55,30,4,11,2,6:4,5,6",
            "100,4,200,1,3,2:1,2,3,4",
            "0,-1: -1,0",
            "9,1,4,7,3,-1,0,5,6,8:3,4,5,6,7,8,9"
    }, delimiter = ':')
    public void TestLongestSequence(String input, String output) {
        final int[] numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        final int[] result = LongestSequence.findLongestConsecutiveSequence(numbers);
        MatcherAssert.assertThat(result, Matchers.equalTo(numbers));
    }
}