package dsa.section15;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


class FibonacciTest {
    @ParameterizedTest
    @CsvSource({"0,1","1,1","2,1","3,2", "4,3", "5,5", "6,8", "7,13", "8,21", "9,34", "10,55"})
    public void ShouldReturnFibonacciNumber(int input, int expected
    ) {
//        assertEquals(expected, new Fibonacci().fibonacciSequenceAsList(input));
//        assertEquals(expected, new Fibonacci().fibonacciSequenceAsArray(input));
//        assertEquals(expected, new Fibonacci().fibonacciSequenceRecursiveList(input));
        assertEquals(expected, new Fibonacci().fibonacciSequenceRecursiveArray(input));
    }

}