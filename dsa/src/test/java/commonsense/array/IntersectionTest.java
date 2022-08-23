package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class IntersectionTest {
    @ParameterizedTest
    @CsvSource(value = {"1;1:1",
            "1,2;2,1:1,2",
            "1,2;2,1:1,2",
            "1,2,3;2,1,4:1,2"}, delimiter = ':')
    public void shouldFindIntersection(String input, String output) {
        final String[] inAndOut = input.split(";");
        final int[] expected = convertToIntArray(output);
        final int[] arrayA = convertToIntArray(inAndOut[0]);
        final int[] arrayB = convertToIntArray(inAndOut[1]);
        final int[] result = new Intersection().findTheIntersection(arrayA, arrayB);
        MatcherAssert.assertThat(result, Matchers.is(expected));
    }

    private int[] convertToIntArray(String output) {
        return Arrays.stream(output.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}