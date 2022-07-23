package commonsense.search;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {
    @Test
    public void shouldReturnEmptyOptionalWhenItemNotFound() {
        String itemToFind = "Hi";
        String[] array = new String[]{};

        LinearSearch<String> ls = new LinearSearch<>();
        Optional<Integer> result = ls.search(array,itemToFind);
        assertThat(result, Matchers.equalTo(Optional.empty()));
    }

    @Test
    public void shouldReturnItemIndexWhenItemFound() {
        String itemToFind = "Hi";
        String[] array = new String[]{"Hi"};

        LinearSearch<String> ls = new LinearSearch<>();
        Optional<Integer> result = ls.search(array,itemToFind);
        assertThat(result.get(), Matchers.equalTo(0));

    }
}