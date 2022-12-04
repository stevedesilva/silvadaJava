package commonsense.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringReversalTest {
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"a,a","abcdef,fedcba","1234567,7654321"})
    public void shouldReverseString(String word, String expected) {

    }

}