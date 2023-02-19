package commonsense.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSelectTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1:0,1",
            "1,2:1,2",
            "2,1:1,2",
            "3,2,1:2,3",
            "4,3,2,1:3,4",
            "5,4,3,2,1:4,5",
            "6,5,4,3,2,1:5,6",
            "7,6,5,4,3,2,1:6,7",
            "8,7,6,5,4,3,2,1:7,8",

    }, delimiter = ':')
    public void shouldSelectQuickIndexValueArray(String input, String output) {
        final int[] inputUnsortedInts= Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        final int[] expectedSortedInts = Arrays.stream(output.split(",")).mapToInt(Integer::parseInt).toArray();
        int indexToFind = expectedSortedInts[0];
        int expectedValue = expectedSortedInts[1];
        MatcherAssert.assertThat(new QuickSelect(inputUnsortedInts).select(indexToFind,0,inputUnsortedInts.length - 1), Matchers.is(expectedValue));
    }

}