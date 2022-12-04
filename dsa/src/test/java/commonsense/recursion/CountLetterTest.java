package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static commonsense.recursion.StringReversal.MINIMUM_INPUT_OF_ONE_NOT_MET;

class CountLetterTest {

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"x,1","abxdxf,2","zxXxz,3","xbxdxX,4","cbdddd,0"})
    public void shouldCountLetterXInWord(String word, int expected) {
        MatcherAssert.assertThat(CountLetter.countXs(word), Matchers.equalTo(expected));
    }

    @Test
    public void shouldThrowExceptionCountLetterXInWord() {
        final IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> CountLetter.countXs(""));
        MatcherAssert.assertThat(illegalArgumentException.getMessage(), Matchers.equalTo(MINIMUM_INPUT_OF_ONE_NOT_MET));
    }

}