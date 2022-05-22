package section15;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import section15.standard.Fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FibonacciTest {
    @ParameterizedTest
    @CsvSource({"0,0","1,1","2,1","3,2", "4,3", "5,5", "6,8", "7,13", "8,21", "9,34", "10,55"})
    public void ShouldReturnFibonacciNumber(int input, int expected
    ) {
        assertEquals(expected, new Fibonacci().fibonacciSequenceIterativeAsList(input));
        assertEquals(expected, new Fibonacci().fibonacciSequenceIterativeAsArray(input));
        assertEquals(expected, new Fibonacci().fibonacciSequenceIterativeAsArrayAlternative(input));

        assertEquals(expected, new Fibonacci().fibonacciSequenceRecursiveList(input));
        assertEquals(expected, new Fibonacci().fibonacciSequenceSpaceOfNRecursiveArray(input));
        assertEquals(expected, new Fibonacci().fibonacciRecursiveSpaceOf1(input));
    }

}