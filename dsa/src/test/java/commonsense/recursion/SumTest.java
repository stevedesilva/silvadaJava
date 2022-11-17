package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SumTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,2:3",
            "1,3:6",
            "1,4:10",
            "1,5:15",
            "1,6:21",
            "1,7:28",
            "1,8:36",
            "1,9:45",
            "1,10:55",
    }, delimiter = ':')
    public void shouldSumNumberBetweenRangeNonTailRecursion(String nums, int want) {
        final String[] lowHigh = nums.split(",");
        Integer low = Integer.valueOf(lowHigh[0]);
        Integer high = Integer.valueOf(lowHigh[1]);
        final int got = new Sum().sumNumberBetweenRangeNonTailRecursion(low,high);
        MatcherAssert.assertThat(got, Matchers.equalTo(want));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2:3",
            "1,3:6",
            "1,4:10",
            "1,5:15",
            "1,6:21",
            "1,7:28",
            "1,8:36",
            "1,9:45",
            "1,10:55",
    }, delimiter = ':')
    public void shouldSumNumberBetweenRangeTailRecursion(String nums, int want) {
        final String[] lowHigh = nums.split(",");
        Integer low = Integer.valueOf(lowHigh[0]);
        Integer high = Integer.valueOf(lowHigh[1]);
        final int got = new Sum().sumNumberBetweenRangeWithTailRecursion(low,high);
        MatcherAssert.assertThat(got, Matchers.equalTo(want));
    }
}