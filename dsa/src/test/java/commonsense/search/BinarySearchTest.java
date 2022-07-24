package commonsense.search;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

class BinarySearchTest {
    @Test
    public void shouldReturnEmptyOptionalWhenItemNotFound() {
        int itemToFind = 9;
        int[] array = new int[]{};

        BinarySearch bs = new BinarySearch();
        Optional<Integer> result = bs.findInSortedArray(itemToFind,array);
        assertThat(result, Matchers.equalTo(Optional.empty()));
    }

    @Test
    public void shouldReturnItemIndexWhenItemFoundOne() {
        int itemToFind = 1;
        int[] array = new int[]{1};

        BinarySearch bs = new BinarySearch();
        Optional<Integer> result = bs.findInSortedArray(itemToFind,array);
        assertThat(result.get(), Matchers.equalTo(0));
    }

    @Test
    public void shouldReturnItemIndexWhenItemFound() {
        int itemToFind = 9;
        int[] array = new int[]{1,2,4,5,6,7,8,9,10};

        BinarySearch bs = new BinarySearch();
        Optional<Integer> result = bs.findInSortedArray(itemToFind,array);
        assertThat(result.get(), Matchers.equalTo(7));
    }

}