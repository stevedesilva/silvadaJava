package commonsense.queue;

import commonsense.stack.ReverseString;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ReverseStringTest {
    @ParameterizedTest
    @CsvSource(value = {"abc:cba","the:eht","abba:abba","abcde:edcba","the abcde:edcba eht"},delimiter = ':')
    public void shouldReverseString(String input, String output) {
        MatcherAssert.assertThat(ReverseString.reverse(input), Matchers.equalTo(output));
    }

    @Test
    public void shouldThrowExceptionWhenMinimumInputNotMet() {
        final IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> ReverseString.reverse(""));
        MatcherAssert.assertThat(illegalArgumentException.getMessage(), Matchers.equalTo(ReverseString.MINIMUM_INPUT_NOT_MET));
    }
}