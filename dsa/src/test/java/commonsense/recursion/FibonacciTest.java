package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @ParameterizedTest
    @CsvSource(value = {"1,1"})
    public void shouldGenerateFibonacciSequence(int input, int expected) {
        MatcherAssert.assertThat(Fibonacci.execute(input), Matchers.equalTo(expected));
    }
}