package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NeedleInHaystackTest {
    @ParameterizedTest
    @CsvSource(value = {
            "a,a:true",
            "a,b:false",
            "acbbac,bb:true",
            "acbfbac,fe:false",
            "thequickandthedead,and:true",
            "thequickandthedead,andd:false",
    }, delimiter = ':')
    public void shouldFindNeedleInHaystack(String input, Boolean expected) {
        String[] array = input.split(",");
        String haystack = array[0];
        String needle = array[1];
        MatcherAssert.assertThat(NeedleInHaystack.findNeedle(needle, haystack), Matchers.is(expected));
    }

    @Test
    public void shouldThrowExceptionWhenInputIsEmpty() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            NeedleInHaystack.findNeedle("", "");
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.is("needle and haystack input cannot be empty"));
    }
}