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

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "a:1",
            "ab:2",
            "a,b,c:3",
            "ac,cd,ef:6",
            "cbd,d,d,d:6",
            "cb,d,d,d,dr,tyh,wer,q:14",
    })
    public void shouldCountLetterInWordArray(String word, int expected) {
        String[] input = word.split(",");
        MatcherAssert.assertThat(CountLetter.countLetters(input), Matchers.equalTo(expected));
    }

}