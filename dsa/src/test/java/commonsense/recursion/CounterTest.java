package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
        final List<Integer> expectedList = Arrays.stream(expected.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        MatcherAssert.assertThat(new Counter().count(num), Matchers.equalTo(expectedList));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0,10:0,2,4,6,8,10",
            "0,20:0,2,4,6,8,10,12,14,16,18,20",
    }, delimiter = ':')
    public void shouldReturnEvenNumber(String nums, String expected) {
        final String[] lowHigh = nums.split(",");
        Integer low = Integer.valueOf(lowHigh[0]);
        Integer high = Integer.valueOf(lowHigh[1]);
        final List<Integer> got = new Counter().countEven(low,high);
        final List<Integer> want = Arrays.stream(expected.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        MatcherAssert.assertThat(got, Matchers.equalTo(want));
    }

}