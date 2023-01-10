package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    // 0 1 1 2 3 5 8 13 21 34 55
    @ParameterizedTest
    @CsvSource(value = {"0,0","1,1","2,1","3,3","4,5","5,8","6,13","7,21","8,34","9,55","10,89"})
    public void shouldGenerateFibonacciSequence(int input, int expected) {
        MatcherAssert.assertThat(Fibonacci.execute(input), Matchers.equalTo(expected));
    }
}