package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StaircaseTest {
    // 8 = 7r(44) + 6r(24) + 5r(13)
    // 7 = 6r + 5r + 4r  = 24 + 13 + 7 = 44
    // 6 = 5r + 4r + 3(4) = 13 + 7 + 4 = 24
    // 5 = 4r + 3(4) + 2(2) = 7 + 4 + 2 = 13
    // 4 = 3(4) + 2(2) + 1(1) = 7
    // 3 = 4
    // 2 = 2
    // 1 = 1
    @ParameterizedTest
    @CsvSource(value = {"1,1","2,2","3,4","4,7","5,13","6,24","7,44","8,81"})
    public void shouldCountSteps(int input, int expected) {
        MatcherAssert.assertThat(Staircase.countNumberOfPaths(input), Matchers.equalTo(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1","2,2","3,4","4,7","5,13","6,24","7,44","8,81"})
    public void shouldCountStepsAlt(int input, int expected) {
        MatcherAssert.assertThat(Staircase.countNumberOfPathsAlt(input), Matchers.equalTo(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1","2,2","3,3","4,4","5,5","6,6","7,7","8,8"})
    public void countNumberOfPathsForOneStep(int input, int expected) {
        MatcherAssert.assertThat(Staircase.countNumberOfPathsForOneStep(input), Matchers.equalTo(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1","2,2","3,3","4,5","5,8","6,13","7,21","8,34"})
    public void countNumberOfPathsForTwoStep(int input, int expected) {
        MatcherAssert.assertThat(Staircase.countNumberOfPathsForTwoStep(input), Matchers.equalTo(expected));
    }

}