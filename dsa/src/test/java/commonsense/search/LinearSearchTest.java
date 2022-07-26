package commonsense.search;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

class LinearSearchTest {
    @Test
    public void shouldReturnEmptyOptionalWhenItemNotFound() {
        String itemToFind = "Hi";
        String[] array = new String[]{};

        LinearSearch<String> ls = new LinearSearch<>();
        Optional<Integer> result = ls.searchUnsorted(array,itemToFind);
        assertThat(result, Matchers.equalTo(Optional.empty()));
    }

    @Test
    public void shouldReturnItemIndexWhenItemFoundUnsorted() {
        String itemToFind = "Hi";
        String[] array = new String[]{"MMA","Zss","LC","Hi","Cazoo"};

        LinearSearch<String> ls = new LinearSearch<>();
        Optional<Integer> result = ls.searchUnsorted(array,itemToFind);
        assertThat(result.get(), Matchers.equalTo(3));

    }
    @Test
    public void shouldReturnItemIndexWhenItemFoundUnSorted() {
        String itemToFind = "Hi";
        String[] array = new String[]{"A","B","C","Hi"};

        LinearSearch<String> ls = new LinearSearch<>();
        Optional<Integer> result = ls.searchUnsorted(array,itemToFind);
        assertThat(result.get(), Matchers.equalTo(0));

    }
    @Test
    public void shouldReturnItemIndexWhenItemFoundSorted() {
        String itemToFind = "B";
        String[] array = new String[]{"A","B","C","D","E"};

        LinearSearch<String> ls = new LinearSearch<>();
        Optional<Integer> result = ls.searchSorted(array,itemToFind);
        assertThat(result.get(), Matchers.equalTo(1));
    }

    @Test
    public void shouldReturnEarlyWhenItemNotFoundSorted() {
        String itemToFind = "B";
        String[] array = new String[]{"A","C","E","G","Z"};

        LinearSearch<String> ls = new LinearSearch<>();
        Optional<Integer> result = ls.searchSorted(array,itemToFind);
        assertThat(result, Matchers.equalTo(Optional.empty()));
    }
}