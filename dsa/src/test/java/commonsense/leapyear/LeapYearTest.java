package commonsense.leapyear;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class LeapYearTest {
    @ParameterizedTest
    @CsvSource({"2016, true", "2024, true","2028, true","2032, true", "2031, false","2033, false"})
    public void ShouldReturnTrueWhenLeapYearExactlyDivisibleByFour(int input, boolean result) {
        MatcherAssert.assertThat(LeapYear.isLeapYear(input), Matchers.equalTo(result));
    }
    @ParameterizedTest
    @CsvSource({"1600, true","2400, true"})
    public void ShouldReturnTrueWhenLeapYearExactlyDivisibleBy400(int input, boolean result) {
        MatcherAssert.assertThat(LeapYear.isLeapYear(input), Matchers.equalTo(result));
    }

    @ParameterizedTest
    @CsvSource({"2100, false","2200, false"})
    public void ShouldReturnTrueWhenLeapYearExactlyDivisibleBy100(int input, boolean result) {
        MatcherAssert.assertThat(LeapYear.isLeapYear(input), Matchers.equalTo(result));
    }
}