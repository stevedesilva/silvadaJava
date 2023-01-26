package commonsense.recursion.dynamic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GolombSequenceTest {
    @ParameterizedTest
    @CsvSource(value = {"1,1"})
    public void shouldCalculateGolombSequence(int input, int expected) {
        MatcherAssert.assertThat(GolombSequence.execute(input), Matchers.equalTo(expected));
    }
}