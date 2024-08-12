package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static commonsense.recursion.StringReversal.MINIMUM_INPUT_OF_ONE_NOT_MET;

class StringReversalTest {
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"a,a","abcdef,fedcba","1234567,7654321"})
    public void shouldReverseString(String word, String expected) {
        MatcherAssert.assertThat(StringReversal.reverse(word), Matchers.equalTo(expected));
    }

    @Test
    public void shouldThrowExceptionReverseString() {
        final IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> StringReversal.reverse(""));
        MatcherAssert.assertThat(illegalArgumentException.getMessage(), Matchers.equalTo(MINIMUM_INPUT_OF_ONE_NOT_MET));
    }

    @Test
    public void shouldReverseArray() {
        String[] word = {"a", "b", "c"};
        String[] expected = {"c", "b", "a"};
        MatcherAssert.assertThat(StringReversal.reverseArrayInline(word), Matchers.equalTo(expected));
    }

    @Test
    public void shouldReverseArray2() {
        String[] word = {"a", "b", "c","d"};
        String[] expected = {"d","c", "b", "a"};
        MatcherAssert.assertThat(StringReversal.reverseArrayInline(word), Matchers.equalTo(expected));
    }
}