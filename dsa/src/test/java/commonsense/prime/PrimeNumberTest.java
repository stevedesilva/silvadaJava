package commonsense.prime;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {

    @ParameterizedTest
    @CsvSource({"0,false", "1,false", "2,true", "3,true", "4,false", "5,true", "6,false", "7,true", "8,false", "9,false", "10,false"})
    public void ShouldFindPrimeNumber(int input, boolean expected
    ) {
        assertEquals(expected, PrimeNumber.isPrime(input));
    }
}