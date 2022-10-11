package commonsense.hashmap;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class SubSetFinderTest {
    @Test
    public void shouldThrowExceptionWhenMinimumInputFromTwoArraysNotMet() {
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SubSetFinder.getSubsetFromArrays(new int[]{}, new int[]{});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo(SubSetFinder.MINIMUM_INPUT_REQUIRED));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':',
            value = {
                    "1,2,3-:1,2,3",
                    "-1,2,3:1,2,3",
                    "1,2,3-1,2,3:1,2,3",
                    "1-1,2,3:1",
                    "1,2,3-1:1",
                    "1,2,6,9,3-1,3,5,9:1,9",
            })
    public void shouldReturnSubsetFromTwoArrays(String input, String output) {
        final String[] arrays = input.split("-");
        final int[] a1 = extractIntArray(arrays[0]);
        final int[] a2 = extractIntArray(arrays[1]);
        final int[] expected = extractIntArray(output);
        final int[] result = SubSetFinder.getSubsetFromArrays(a1, a2);
        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }

    private int[] extractIntArray(String array) {
        return Arrays.stream(array.split(",")).mapToInt(Integer::parseInt).toArray();
    }

}