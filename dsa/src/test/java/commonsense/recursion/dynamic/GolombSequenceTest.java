package commonsense.recursion.dynamic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GolombSequenceTest {

   //      *  1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 12, 12, 12, 12, 12, 12
    @ParameterizedTest
    @CsvSource(value = {"1,1","2,2","3,2","4,3","5,3","10,5"})
    public void shouldCalculateGolombSequence(int input, int expected) {
        MatcherAssert.assertThat(GolombSequence.execute(input), Matchers.equalTo(expected));
    }
}