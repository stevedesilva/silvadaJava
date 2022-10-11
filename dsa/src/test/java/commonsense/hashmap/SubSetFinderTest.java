package commonsense.hashmap;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubSetFinderTest {
    @Test
    public void shouldThrowExceptionWhenMinimumInputFromTwoArraysNotMet() {
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SubSetFinder.getSubsetFromArrays(new int[]{}, new int[]{});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo(SubSetFinder.MINIMUM_INPUT_REQUIRED));
    }

    @Test
    public void shouldReturnSubsetFromTwoArrays() {

    }
}