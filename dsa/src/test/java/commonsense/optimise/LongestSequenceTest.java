package commonsense.optimise;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class LongestSequenceTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1:1",
            "1,2:1,2",
            "1,2,3:1,2,3",
            "1,2,4,5:1,2",
            "10,5,12,3,55,30,4,11,2,6:2,3,4,5,6",
            "100,4,200,1,3,2:1,2,3,4",
            "0,-1: -1,0",
            "9,1,4,7,3,-1,0,5,6,8:3,4,5,6,7,8,9"
    }, delimiter = ':')
    public void TestLongestSequence(String input, String output) {
        final int[] numbers = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        List<Integer> result = LongestSequence.findLongestConsecutiveSequence(numbers);
        List<Integer> expected = Arrays.stream(output.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }
}