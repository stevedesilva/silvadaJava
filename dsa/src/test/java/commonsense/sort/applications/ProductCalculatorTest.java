package commonsense.sort.applications;

import commonsense.sort.QuickSelect;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductCalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {
            "6-1:6",
            "6,5,4,3,2,1-2:11",
            "7,6,5,4,3,2-3:18",
            "8,7,6,5,4,3,2,1-1:8",
    }, delimiter = ':')
    public void shouldFindDuplicateArray(String arrayAndRange, int result) {
        final String[] input = arrayAndRange.split("-");
        int[] array = Arrays.stream(input[0].split(",")).mapToInt(Integer::parseInt).toArray();
        int range = Integer.parseInt(input[1]);
        MatcherAssert.assertThat(new ProductCalculator().findGreatestProductForNumbers(array, range), Matchers.is(result));
    }

    @Test
    public void shouldThrowExceptionIfInputArrayDoesNotMeetMinimumLength() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            new ProductCalculator().findGreatestProductForNumbers(new int[]{},0);
        });
        MatcherAssert.assertThat(ex.getMessage(), Matchers.is(QuickSelect.ARRAY_MUST_CONTAIN_AT_LEAST_ONE_VALUE));
    }
}