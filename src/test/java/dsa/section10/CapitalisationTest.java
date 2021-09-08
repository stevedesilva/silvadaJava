package dsa.section10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CapitalisationTest {
    @ParameterizedTest
    @CsvSource({"A, A", "a,A", "ab, Ab", "abc, Abc", "abcd efg, Abcd Efg"})
    public void shouldCapitalise(String input, String expected) {
        Capitalisation capitalisation = new Capitalisation();
        String actual = capitalisation.capitaliseFirstWordInSentence(input);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void shouldCapitaliseWithSpecialCharacters() {
        String sentence = "look, it is not working!";
        String expected = "Look, It Is Not Working!";
        Capitalisation capitalisation = new Capitalisation();
        String actual = capitalisation.capitaliseFirstWordInSentence(sentence);
        Assertions.assertEquals(expected,actual);
    }
}