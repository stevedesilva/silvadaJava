package commonsense.recursion.dynamic;

import commonsense.recursion.Staircase;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class StaircaseMemoisationTest {
    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,4", "4,7", "5,13", "6,24", "7,44", "8,81"})
    public void shouldCountStepsWithMemoization(int input, int expected) {
        MatcherAssert.assertThat(Staircase.countNumberOfPathsWithMemoization(input), Matchers.equalTo(expected));
    }
}