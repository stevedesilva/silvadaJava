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
    public void findFirstDuplicateShouldThrowExceptionWhenMinimumInputNotFound() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DuplicateFinder.findFirstDuplicate(new String[]{});
        });
        MatcherAssert.assertThat(exception.getMessage(),Matchers.equalTo(DuplicateFinder.MINIMUM_INPUT_REQUIRED));
    }
    @Test
    public void findFirstDuplicateShouldThrowExceptionWhenDuplicateNotFound() {
        final NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            DuplicateFinder.findFirstDuplicate(new String[]{"a","b","c"});
        });
        MatcherAssert.assertThat(exception.getMessage(),Matchers.equalTo(DuplicateFinder.NO_DUPLICATE_FOUND));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "cat,dog,mouse,dog:dog",
    })
    public void findFirstDuplicateShouldReturnDuplicate(String input, String expected) {
        MatcherAssert.assertThat(DuplicateFinder.findFirstDuplicate(input.split(",")),Matchers.equalTo(expected));
    }


    @Test
    public void findFirstNonDuplicateShouldThrowExceptionWhenMinimumInputNotFound() {
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            DuplicateFinder.findFirstNonDuplicate(new String[]{});
        });
        MatcherAssert.assertThat(exception.getMessage(),Matchers.equalTo(DuplicateFinder.MINIMUM_INPUT_REQUIRED));
    }
    @Test
    public void findFirstNonDuplicateShouldThrowExceptionWhenDuplicateNotFound() {
        final NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            DuplicateFinder.findFirstNonDuplicate(new String[]{"a","b","c","a","b","c"});
        });
        MatcherAssert.assertThat(exception.getMessage(),Matchers.equalTo(DuplicateFinder.NON_DUPLICATE_FOUND));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "a,a,b,c,d,d,e,e:b",
            "a,a,b,y,d,d,b,e,e:y",
            "a,a,b,c,d,d,e,b,e:c",
            "at,at,bat,you,bat,you,dog,dude,egg,egg:dog",
    })
    public void findFirstNonDuplicateShouldReturnNonDuplicate(String input, String expected) {
        MatcherAssert.assertThat(DuplicateFinder.findFirstNonDuplicate(input.split(",")),Matchers.equalTo(expected));
    }

}