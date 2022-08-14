package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateTest {
    @Test
    public void noDuplicates() {
        int[] array = new int[] {4,2,1,3};
        Duplicate duplicate = new Duplicate();
        boolean result = duplicate.hasDuplicates(array);
        MatcherAssert.assertThat(false,Matchers.is(result));
    }

    @Test
    public void hasDuplicates() {
        int[] array = new int[] {4,2,1,4};
        Duplicate duplicate = new Duplicate();
        boolean result = duplicate.hasDuplicates(array);
        MatcherAssert.assertThat(true,Matchers.is(result));
    }
}