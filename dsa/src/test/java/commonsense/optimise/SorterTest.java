package commonsense.optimise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    private final Sorter sorter = new Sorter();

    @Test
    void testSortCharactersInAnyOrder() {
        List<Character> input = Arrays.asList('a', 'b', 'a', 'c', 'b', 'a');
        List<Character> actualOutput = sorter.sortCharactersInAnyOrder(input);

        // Verify the output contains the correct number of occurrences for each character
        assertEquals(Collections.frequency(actualOutput, 'a'), 3);
        assertEquals(Collections.frequency(actualOutput, 'b'), 2);
        assertEquals(Collections.frequency(actualOutput, 'c'), 1);
        assertEquals(actualOutput.size(), input.size());
    }

    @Test
    void testEmptyList() {
        List<Character> input = Arrays.asList();
        List<Character> actualOutput = sorter.sortCharactersInAnyOrder(input);
        assertTrue(actualOutput.isEmpty());
    }

    @Test
    void testSingleCharacterList() {
        List<Character> input = Arrays.asList('x');
        List<Character> actualOutput = sorter.sortCharactersInAnyOrder(input);
        assertEquals(Collections.frequency(actualOutput, 'x'), 1);
        assertEquals(actualOutput.size(), input.size());
    }

    @Test
    void testListWithDuplicates() {
        List<Character> input = Arrays.asList('z', 'z', 'z', 'z');
        List<Character> actualOutput = sorter.sortCharactersInAnyOrder(input);
        assertEquals(Collections.frequency(actualOutput, 'z'), 4);
        assertEquals(actualOutput.size(), input.size());
    }
}