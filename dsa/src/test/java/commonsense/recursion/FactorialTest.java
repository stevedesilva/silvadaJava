package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @ParameterizedTest
    @CsvSource( value = {"1,1","2,2","3,6","4,24","5,120"})
    public void factorialTest(int input, int expected) {
        Factorial factorial = new Factorial();
        MatcherAssert.assertThat(factorial.calculateFactorial(input), Matchers.equalTo(expected));
    }

}