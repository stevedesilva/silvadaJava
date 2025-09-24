package commonsense.optimise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BodyTemperatureTest {

    private final BodyTemperature bodyTemperature = new BodyTemperature();

    // Test minimum list length of 1, throw exception for length less than 1
    @ParameterizedTest
    @CsvSource({
            "'97.5', true", // Valid case
            "'', false"     // Invalid case
    })
    void testMinimumListLength(String input, boolean isValid) {
        List<Double> temperatures = parseInput(input);
        if (isValid) {
            assertDoesNotThrow(() -> bodyTemperature.sortTemperatures(temperatures));
        } else {
            assertThrows(IllegalArgumentException.class, () -> bodyTemperature.sortTemperatures(temperatures));
        }
    }

    // Test all values in list of Double between 97.0 and 99.0 inclusive - throw exception for out of range values
    @ParameterizedTest
    @CsvSource({
            "'97.0,98.5,99.0', true",  // Valid case
            "'96.9,98.5,99.1', false"  // Invalid case
    })
    void testValuesInRange(String input, boolean isValid) {
        List<Double> temperatures = parseInput(input);
        if (isValid) {
            assertDoesNotThrow(() -> bodyTemperature.sortTemperatures(temperatures));
        } else {
            assertThrows(IllegalArgumentException.class, () -> bodyTemperature.sortTemperatures(temperatures));
        }
    }

    // Test sorted list using parameterized test,
    // input is list of doubles, out is sorted list of doubles
    @ParameterizedTest
    @CsvSource(value = {
            "'98.6,97.5,99.0:97.5,98.6,99.0'",
            "'99.0,98.0,97.0:97.0,98.0,99.0'",
            "'97.2,97.8,98.4,98.1:97.2,97.8,98.1,98.4'"}, delimiter = ':')
    void testSortedList(String input, String expected) {
        List<Double> temperatures = parseInput(input);
        List<Double> expectedSorted = parseInput(expected);
        List<Double> actualSorted = bodyTemperature.sortTemperatures(temperatures);
        assertEquals(expectedSorted, actualSorted);
    }

    private List<Double> parseInput(String input) {
//
//        if (input == null || input.trim().isEmpty()) {
//            return List.of();
//        }
//        String[] parts = input.split(",");
//        return java.util.Arrays.stream(parts)
//                .map(String::trim)
//                .map(Double::parseDouble)
//                .toList();

    }
}