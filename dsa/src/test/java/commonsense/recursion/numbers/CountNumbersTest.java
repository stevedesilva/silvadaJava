package commonsense.recursion.numbers;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

class CountNumbersTest {

    @Test
    public void shouldReturnIntegersFromMultidimensionalArrayNumbersOnly() {
        ArrayElement input = ArrayElement.of(
                IntegerElement.of(1),
                IntegerElement.of(2),
                IntegerElement.of(3)
        );
        List<Integer> actual = new CountNumbers().collectNumbers(input);
        List<Integer> expected = List.of(1, 2, 3);
        MatcherAssert.assertThat(actual, Matchers.equalTo(expected));
    }

    @Test
    public void shouldReturnIntegersFromMultidimensionalArrayNumbersAndOneArray() {
        ArrayElement input = ArrayElement.of(
                IntegerElement.of(1),
                IntegerElement.of(2),
                IntegerElement.of(3),
                ArrayElement.of(IntegerElement.of(4), IntegerElement.of(5), IntegerElement.of(6))
        );
        List<Integer> actual = new CountNumbers().collectNumbers(input);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        MatcherAssert.assertThat(actual, Matchers.equalTo(expected));
    }

    @Test
    public void shouldReturnIntegersFromMultidimensionalArrayNumbersAndTwoArrays() {
        ArrayElement input = ArrayElement.of(
                IntegerElement.of(1),
                IntegerElement.of(2),
                IntegerElement.of(3),
                ArrayElement.of(IntegerElement.of(4), IntegerElement.of(5), IntegerElement.of(6)),
                IntegerElement.of(7)
        );
        List<Integer> actual = new CountNumbers().collectNumbers(input);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
        MatcherAssert.assertThat(actual, Matchers.equalTo(expected));
    }

    @Test
    public void shouldReturnIntegersFromMultidimensionalArray() {
        ArrayElement input = ArrayElement.of(
                IntegerElement.of(1),
                IntegerElement.of(2),
                IntegerElement.of(3),
                ArrayElement.of(IntegerElement.of(4), IntegerElement.of(5), IntegerElement.of(6)),
                IntegerElement.of(7),
                ArrayElement.of(IntegerElement.of(8),
                        ArrayElement.of(IntegerElement.of(9), IntegerElement.of(10), IntegerElement.of(11),
                                ArrayElement.of(IntegerElement.of(12), IntegerElement.of(13), IntegerElement.of(14))
                        )
                ),
                ArrayElement.of(IntegerElement.of(15), IntegerElement.of(16), IntegerElement.of(17), IntegerElement.of(18), IntegerElement.of(19),
                        ArrayElement.of(IntegerElement.of(20), IntegerElement.of(21), IntegerElement.of(22),
                                ArrayElement.of(IntegerElement.of(23), IntegerElement.of(24), IntegerElement.of(25),
                                        ArrayElement.of(
                                                IntegerElement.of(26), IntegerElement.of(27), IntegerElement.of(29)
                                        )
                                ), IntegerElement.of(30), IntegerElement.of(31)
                        ), IntegerElement.of(32)
                ), IntegerElement.of(33)
        );

        List<Integer> actual = new CountNumbers().collectNumbers(input);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33);
        MatcherAssert.assertThat(actual, Matchers.equalTo(expected));
    }

}