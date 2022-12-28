package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangularNumbersTest {
    @ParameterizedTest
    @CsvSource(value = {"1,1","2,3","3,6","4,10","5,15","6,21","7,28","8,36","9,45","10,55"})
    public void shouldReturnTriangularNumbers(int input, int expected) {
        MatcherAssert.assertThat(TriangularNumbers.execute(input), Matchers.equalTo(expected));
    }
    @ParameterizedTest
    @CsvSource(value = {"1,1","2,3","3,6","4,10","5,15","6,21","7,28","8,36","9,45","10,55"})
    public void shouldReturnTriangularNumbersAlt(int input, int expected) {
        MatcherAssert.assertThat(TriangularNumbers.executeAlt(input), Matchers.equalTo(expected));
    }
}