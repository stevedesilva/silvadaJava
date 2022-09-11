package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberCountTest {

    @Test
    public void shouldReturnTotalOfOnesAlt(){
        int expected = 5;
        int[][] input = new int[][]{{0, 0, 0, 1}, {1, 1, 0}, {0, 0, 1}, {1}, {0}};
        final int got = NumberCount.countTheOnes(input);
        MatcherAssert.assertThat(got,Matchers.equalTo(expected));
    }

    @Test
    public void shouldReturnTotalOfOnes(){
        int expected = 6;
        int[][] input = new int[][]{{0, 1, 0, 0, 1}, {1, 1, 0}, {0, 0, 1}, {1}, {0}};
        final int got = NumberCount.countTheOnes(input);
        MatcherAssert.assertThat(got,Matchers.equalTo(expected));
    }

    @Test
    public void shouldReturnTotalOfOnesForEmptyInnerArray(){
        int expected = 0;
        int[][] input = new int[][]{{}, {}, {}, {}, {}};
        final int got = NumberCount.countTheOnes(input);
        MatcherAssert.assertThat(got,Matchers.equalTo(expected));
    }

    @Test
    public void shouldThrowExceptionWhenInputArrayIsEmpty(){
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberCount.countTheOnes(new int[][]{});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo("input array is mandatory"));

    }

}