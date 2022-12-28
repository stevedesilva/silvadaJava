package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FindIndexTest {
    @Test
    public void shouldThrowExceptionIfCharNotFoundInString() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FindIndex.findFirstIndex("ssss", 'c');
        });
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "x,x:0",
            "ax,x:1",
            "abcde,e:4",
            "abcde,b:1",
            "abcdefghijk,k:10",
            "abcde,c:2",
    })
    public void shouldFindFirstIndexForXInString(String input, int expectedIndex) {
        String[] inputs = input.split(",");
        String word = inputs[0];
        char charToFind = inputs[1].charAt(0);
        MatcherAssert.assertThat(FindIndex.findFirstIndex(word, charToFind), Matchers.equalTo(expectedIndex));
    }
}