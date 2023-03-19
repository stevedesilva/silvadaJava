package commonsense.sort.applications;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.function.Function;

class LargestValueTest {

    private final static String[] values = {
            ":",
            "1:1",
            "1,2:2",
            "3,1,2:3",
            "10,3,1,2,8,19,22:19",
    };

    @ParameterizedTest
    @CsvSource(delimiter = ':',
            value = {
                    ":",
                    "1:1",
                    "1,2:2",
                    "3,1,2:3",
                    "10,3,1,2,8,19,22:19",
            })
    void findLargestValueN(String input, Integer expected) {
        execute(input, expected, (in) ->LargestValue.findLargestValueN(in));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':',
            value = {
                    ":",
                    "1:1",
                    "1,2:2",
                    "3,1,2:3",
                    "10,3,1,2,8,19,22:19",
            })
    void findLargestValueN2(String input, Integer expected) {
        execute(input, expected, (in) ->LargestValue.findLargestValueN2(in));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':',
            value = {
                    ":",
                    "1:1",
                    "1,2:2",
                    "3,1,2:3",
                    "10,3,1,2,8,19,22:19",
            })
    void findLargestValueNLogN(String input, Integer expected) {
        execute(input, expected, (in) ->LargestValue.findLargestValueNLogN(in));
    }

    private void execute(String input, Integer expected, Function<Integer[], Integer> fn) {
        if (input == null) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                LargestValue.findLargestValueN(new Integer[]{});
            });
        } else {
            final String[] numbersAsStr = input.split(",");
            final Integer[] numbers = Arrays.stream(numbersAsStr).map(Integer::parseInt).toArray(Integer[]::new);
            MatcherAssert.assertThat(fn.apply(numbers), Matchers.equalTo(expected));
        }
    }

}