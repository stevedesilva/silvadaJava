package commonsense.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class InsertionSortTest {
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2,1:1,2", "3,2,1:1,2,3", "4,3,2,1:1,2,3,4","5,4,3,2,1:1,2,3,4,5"}, delimiter = ':')
    public void shouldSortArray(String input, String output) {
        final int[] inputUnsortedInts= Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        final int[] expectedSortedInts = Arrays.stream(output.split(",")).mapToInt(Integer::parseInt).toArray();
        MatcherAssert.assertThat(new InsertionSort().sort(inputUnsortedInts), Matchers.is(expectedSortedInts));
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2,1:1,2", "3,2,1:1,2,3", "4,3,2,1:1,2,3,4","5,4,3,2,1:1,2,3,4,5"}, delimiter = ':')
    public void shouldSortOfficialArray(String input, String output) {
        final int[] inputUnsortedInts= Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        final int[] expectedSortedInts = Arrays.stream(output.split(",")).mapToInt(Integer::parseInt).toArray();
        MatcherAssert.assertThat(new InsertionSort().sortOfficial(inputUnsortedInts), Matchers.is(expectedSortedInts));
    }
}