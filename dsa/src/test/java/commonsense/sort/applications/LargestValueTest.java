package commonsense.sort.applications;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

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
        if (input == null) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                LargestValue.findLargestValueN(new Integer[]{});
            });
        } else {
            final String[] numbersAsStr = input.split(",");
            collector.toArray(String[]::new);
            final Integer[] numbers = Arrays.stream(numbersAsStr).mapToInt(Integer::parseInt).toArray(Integer[]::new);
            MatcherAssert.assertThat(LargestValue.findLargestValueN(numbers),Matchers.equalTo(expected));
        }
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
        if (input == null) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                LargestValue.findLargestValueN(new Integer[]{});
            });
        } else {
            final String[] numbersAsStr = input.split(",");
            final Integer[] numbers = Arrays.stream(numbersAsStr).mapToInt(Integer::parseInt).toArray();
            MatcherAssert.assertThat(LargestValue.findLargestValueN(numbers),Matchers.equalTo(expected));
        }
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
        if (input == null) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                LargestValue.findLargestValueN(new Integer[]{});
            });
        } else {
            final String[] numbersAsStr = input.split(",");
            final Integer[] numbers = Arrays.stream(numbersAsStr).mapToInt(Integer::parseInt).toArray();
//            MatcherAssert.assertThat(LargestValue.findLargestValueN(numbers),Matchers.equalTo(expected));
            final Integer result = execute();
            MatcherAssert.assertThat(result,Matchers.equalTo(expected));
        }
    }

    private Integer execute(Function<Integer[],Integer> fn){
        return fn.apply(new Integer[]{});
    }

}