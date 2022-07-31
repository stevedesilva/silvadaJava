package commonsense.leapyear;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LeapYearTest {
    @ParameterizedTest
    @CsvSource({"2016, true", "2024, true","2028, true","2032, true", "2031, false","2033, false"})
    public void ShouldReturnTrueWhenLeapYear(int input, boolean result) {
        MatcherAssert.assertThat(LeapYear.isLeapYear(input), Matchers.equalTo(result));
    }
}