package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberCountTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0,0,1;1,1,0;0,0,1;1;0:5"}, delimiter = ':')
    public void shouldReturnTotalOfOnesAlt(String input, int expected) {
        final String[] innerArrays = input.split(";");
        List<int[]> intArray = new ArrayList<>();
        for (int i = 0; i < innerArrays.length; i++) {
            var in = Arrays.stream(innerArrays[i].split(",")).mapToInt(Integer::parseInt).toArray();
            intArray.add(in);
        }
        final int[][] ints = intArray.stream().toArray(int[][]::new);

        final int got = NumberCount.countTheOnes(ints);
        MatcherAssert.assertThat(got,Matchers.equalTo(expected));
    }

    @Test
    public void shouldReturnTotalOfOnes() {
        int expected = 6;
        int[][] input = new int[][]{{0, 1, 0, 0, 1}, {1, 1, 0}, {0, 0, 1}, {1}, {0}};
        final int got = NumberCount.countTheOnes(input);
        MatcherAssert.assertThat(got, Matchers.equalTo(expected));
    }

    @Test
    public void shouldReturnTotalOfOnesForEmptyInnerArray() {
        int expected = 0;
        int[][] input = new int[][]{{}, {}, {}, {}, {}};
        final int got = NumberCount.countTheOnes(input);
        MatcherAssert.assertThat(got, Matchers.equalTo(expected));
    }

    @Test
    public void shouldThrowExceptionWhenInputArrayIsEmpty() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberCount.countTheOnes(new int[][]{});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo("input array is mandatory"));

    }

}