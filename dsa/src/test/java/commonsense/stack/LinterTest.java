package commonsense.stack;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LinterTest {

    @ParameterizedTest
    @CsvSource(value = {
            "abscefg|true",
            "(var x = {y: [1,2,3]})|true",

    },delimiter = '|')
    public void shouldLintData(String input, Boolean expected) {
        LinterFunctions linter = new Linter(input);
        linter.Validate();
        MatcherAssert.assertThat(linter.Validate(), Matchers.is(true));
    }

    @Test
    public void shouldThrowExceptionWhenMinimumInputNotMet() {
        final Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LinterFunctions linter = new Linter("");
            linter.Validate();
        });
        MatcherAssert.assertThat(throwable.getMessage(), Matchers.is(LinterFunctions.MINIMUM_INPUT_NOT_MET));
    }
    @Test
    public void shouldThrowExceptionWhenErrMissingClosingBrace() {
        final Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LinterFunctions linter = new Linter("(var x = 2;");
            linter.Validate();
        });
        MatcherAssert.assertThat(throwable.getMessage(), Matchers.is(LinterFunctions.ERROR_MISSING_CLOSING_BRACE));
    }
    @Test
    public void shouldThrowExceptionWhenErrMissingOpeningBrace() {
        final Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LinterFunctions linter = new Linter("var x = 2;)");
            linter.Validate();
        });
        MatcherAssert.assertThat(throwable.getMessage(), Matchers.is(LinterFunctions.ERROR_MISSING_OPENING_BRACE));
    }
    @Test
    public void shouldThrowExceptionWhenErrBraceMismatch() {
        final Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            LinterFunctions linter = new Linter("(var x = [1,2,3)];");
            linter.Validate();
        });
        MatcherAssert.assertThat(throwable.getMessage(), Matchers.is(LinterFunctions.ERROR_BRACE_MISMATCH));
    }

}