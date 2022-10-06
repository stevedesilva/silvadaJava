package commonsense.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LuhnAlgorithmTest {
    @ParameterizedTest
    @CsvSource(value = {"123456,false"})
    public void shouldValidateCreditCard(int input, boolean expected) {
        final int[] array = Integer.toString(input).chars().map(c -> c - '0').toArray();



    }
}