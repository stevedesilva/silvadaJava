package section9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AnagramTest {

    @ParameterizedTest
    @CsvSource({"abc, CBA","abCc, cBac","albCac, cbacal","alb cac, cba cal"})
    void shouldMatchAnagramA(String wordA, String expected){
        Assertions.assertTrue(Anagram.execute(wordA,expected));
    }

    @ParameterizedTest
    @CsvSource({"rail safety, fairy tales", "Rail safety, Fairy tales"})
    void shouldMatchAnagram(String wordA, String expected){
        Assertions.assertTrue(Anagram.execute(wordA,expected));
    }

    @ParameterizedTest
    @CsvSource({"rail!% safety!, fairy& tails", "Rail! Safety!, fairy tails"})
    void shouldMatchAnagramIgnoringNoChars(String wordA, String expected){
        Assertions.assertFalse(Anagram.execute(wordA,expected));
    }

    @ParameterizedTest
    @CsvSource({"Hi there, bye there",","})
    void shouldNotMatchAnagram(String wordA, String expected){
        Assertions.assertFalse(Anagram.execute(wordA,expected));
    }

}

