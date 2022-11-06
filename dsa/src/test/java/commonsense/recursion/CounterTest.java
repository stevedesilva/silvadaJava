package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1:1",
            "2:2,1",
            "3:3,2,1",
            "4:4,3,2,1",
            "5:5,4,3,2,1",
            "10:10,9,8,7,6,5,4,3,2,1"
    }, delimiter = ':')
    public void shouldReturnNumber(int num, String expected) {
        Counter counter = new Counter();
        final List<Integer> result = counter.count(num);
        final List<Integer> expectedList = Arrays.stream(expected.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        MatcherAssert.assertThat(result, Matchers.equalTo(expectedList));
    }

}