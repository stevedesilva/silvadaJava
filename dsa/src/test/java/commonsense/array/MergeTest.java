package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;


class MergeTest {

    @Test
    public void emptyArrays() {
        final int[] inputA = {};
        final int[] inputB = {};
        final int[] result = new Merge().mergeArrays(inputA, inputB);

        final int[] expected = {};
        MatcherAssert.assertThat(result, Matchers.is(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:1,2","4,4:4,4"}, delimiter = ':')
    public void oneEmptyArray(String input, String output) {
        final int[] full = toIntArray(input);
        final int[] empty = {};
        expectOneArray(output, full, empty);
        expectOneArray(output, empty, full);
    }

    private void expectOneArray(String output, int[] inputA, int[] inputB) {
        final int[] result = new Merge().mergeArrays(inputA, inputB);

        final int[] expected = toIntArray(output);
        ;
        MatcherAssert.assertThat(result, Matchers.is(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2-3,4:1,2,3,4"}, delimiter = ':')
    public void shouldMergeTwoArrays(String input, String output) {
        final String[] inArray = input.split("-");
        final int[] inputA = toIntArray(inArray[0]);
        final int[] inputB = toIntArray(inArray[1]);
        expectOneArray(output, inputA, inputB);
    }

    private int[] toIntArray(String output) {
        return Arrays.stream(output.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}