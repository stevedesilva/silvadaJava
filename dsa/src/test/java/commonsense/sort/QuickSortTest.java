package commonsense.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class QuickSortTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1:1",
            "1,2:1,2",
            "2,1:1,2",
            "3,2,1:1,2,3",
            "4,3,2,1:1,2,3,4",
            "5,4,3,2,1:1,2,3,4,5",
            "6,5,4,3,2,1:1,2,3,4,5,6",
            "7,6,5,4,3,2,1:1,2,3,4,5,6,7"
    }, delimiter = ':')
    public void shouldSortArray(String input, String output) {
        final int[] inputUnsortedInts= Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        final int[] expectedSortedInts = Arrays.stream(output.split(",")).mapToInt(Integer::parseInt).toArray();
        MatcherAssert.assertThat(new QuickSort(inputUnsortedInts).sort(0,inputUnsortedInts.length - 1), Matchers.is(expectedSortedInts));
    }

}