package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

class NumberCountTest {

//    @Test
//    public void shouldThrowExceptionWhenInputArrayIsEmpty(){
//        int expected = 1;
//        int[][] input = new int[][]{};
//    }
    @Test
    public void shouldThrowExceptionWhenInputArrayIsEmpty(){
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NumberCount.countTheOnes(new int[][]{});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo("input array is mandatory"));

    }

}