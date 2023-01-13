package commonsense.recursion.dynamic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FibonacciTest {
    // 0 1 1 2 3 5 8 13 21 34 55
    @ParameterizedTest
    @CsvSource(value = {"0,0","1,1","2,1","3,2","4,3","5,5","6,8","7,13","8,21","9,34","10,55", "11,89"})
    public void shouldGenerateFibonacciSequence(int input, int expected) {
        MatcherAssert.assertThat(Fibonacci.fibonacci(input), Matchers.equalTo(expected));
    }
}