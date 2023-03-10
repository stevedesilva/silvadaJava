package commonsense.sort.applications;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {
    @ParameterizedTest
    @CsvSource(value = {
            "0,2:1",
            "5,2,4,1,0:3",
            "0,1,2,3,5:4",
            "0,1,2,3,4,6,7,8,9,10:5",

    },
            delimiter = ':')
    public void shouldFindMissingNumberFromArray(String input, int expected) {
        final int[] numsToSearch = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();

        MatcherAssert.assertThat(MissingNumber.findMissingNumber(numsToSearch), Matchers.equalTo(expected));
    }
}