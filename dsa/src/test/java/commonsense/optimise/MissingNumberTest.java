package commonsense.optimise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {


    @ParameterizedTest
    @CsvSource(value = {
            "0,2:1",                // Missing number in the middle
            "5,2,4,1,0:3",          // Missing number in the middle
            "0,1,2,3,5:4",          // Missing number in the middle
            "0,1,2,3,4,6,7,8,9,10:5" // Missing number in the middle
    }, delimiter = ':')
    void shouldFindMissingNumberFromArray(String input, int expected) {
        int[] numbers = parseInput(input);
        assertEquals(expected, MissingNumber.find(numbers));
    }

    @Test
    void shouldThrowExceptionForEmptyArray() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MissingNumber.find(new int[]{});
        });
        assertEquals("number array cannot be empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNullArray() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MissingNumber.find(null);
        });
        assertEquals("number array cannot be empty", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForInvalidMissingNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            MissingNumber.find(new int[]{0, 1, 2, 3, 4});
        });
        assertEquals("invalid missing number", exception.getMessage());
    }

    private int[] parseInput(String input) {
        return input.isEmpty() ? new int[]{} :
                java.util.Arrays.stream(input.split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray();
    }

}