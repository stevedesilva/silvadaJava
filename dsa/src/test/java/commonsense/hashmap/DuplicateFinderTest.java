package commonsense.hashmap;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.NoSuchElementException;

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
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "cat,dog,mouse,dog:dog",
            "cat,dog,cat,dog,cat:cat",
            "a,b,c,c:c",
            "a,b,a,c,c:a",
    })
    public void shouldReturnDuplicate(String input, String expected) {
        MatcherAssert.assertThat(DuplicateFinder.findFirstDuplicate(input.split(",")),Matchers.equalTo(expected));
    }


}