package commonsense.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateFinderTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1:0,false",
            "1:1,true",
            "1,2:false",
            "2,1:false",
            "2,1,2:true",
            "3,2,1:false",
            "3,2,3:true",
            "4,3,2,1:false",
            "5,4,3,2,1:false",
            "5,4,3,2,5:true",
            "6,5,4,3,2,1:false",
            "7,6,5,4,3,2,1:false",
            "8,7,6,5,4,3,2,1:false",
            "8,7,6,5,4,3,2,8:true",

    }, delimiter = ':')
    public void shouldFindDuplicateArray(String input, boolean result) {
        final int[] inputUnsortedInts= Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        MatcherAssert.assertThat(new DuplicateFinder().hasDuplicates(inputUnsortedInts), Matchers.is(result));
    }
    @Test
    public void shouldThrowExceptionIfInputArrayDoesNotMeetMinimumLength(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new DuplicateFinder().hasDuplicates(new int[]{});
        });
        MatcherAssert.assertThat(ex.getMessage(), Matchers.is(QuickSelect.ARRAY_MUST_CONTAIN_AT_LEAST_ONE_VALUE));
    }
}