package commonsense.sort;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


class BubbleSortTest {
    @Test
    public void shouldSortOneItemArray() {
        int[] result = new int[]{1};
        MatcherAssert.assertThat(new BubbleSort().sort(new int[]{1}), Matchers.is(result));
    }

    @Test
    public void shouldSortTwoItemArray() {
        int[] result = new int[]{1, 2};
        MatcherAssert.assertThat(new BubbleSort().sort(new int[]{2, 1}), Matchers.is(result));
    }

    @Test
    public void shouldSortThreeItemArray() {
        int[] result = new int[]{1, 2, 3};
        MatcherAssert.assertThat(new BubbleSort().sort(new int[]{2, 3, 1}), Matchers.is(result));
    }
    @Test
    public void shouldSortFourItemArray() {
        int[] result = new int[]{1, 2, 3, 4};
        MatcherAssert.assertThat(new BubbleSort().sort(new int[]{4, 2, 3, 1}), Matchers.is(result));
    }
    @Test
    public void shouldSortFiveItemArray() {
        int[] result = new int[]{1, 2, 3, 4, 5};
        MatcherAssert.assertThat(new BubbleSort().sort(new int[]{4, 2, 5, 3, 1}), Matchers.is(result));
    }
}