package commonsense.hashmap;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateFinderTest {
    @Test
    public void shouldThrowExceptionWhenMinimumInputNotFound() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DuplicateFinder.findFirstDuplicate(new String[]{});
        });
        MatcherAssert.assertThat(exception.getMessage(),Matchers.equalTo(DuplicateFinder.MINIMUM_INPUT_REQUIRED));
    }
    @Test
    public void shouldThrowExceptionWhenDuplicateNotFound() {
        final NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            DuplicateFinder.findFirstDuplicate(new String[]{"a","b","c"});

        });
        MatcherAssert.assertThat(exception.getMessage(),Matchers.equalTo(DuplicateFinder.NO_DUPLICATE_FOUND));
    }
}