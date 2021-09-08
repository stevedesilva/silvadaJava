package dsa.section10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CapitalisationTest {
    @ParameterizedTest
    @CsvSource({"A, A", "a,A", "ab, Ab", "abc, Abc", "abcd efg, Abcd Efg"})
    public void shouldCapitaliseWithSpecialCharacters(String input, String expected) {
        Assertions.assertEquals(expected, new Capitalisation().capitaliseFirstWordInSentenceUsingByteArray(input));
        Assertions.assertEquals(expected, new Capitalisation().capitaliseFirstCharInWordUsingCharArray(input));
        Assertions.assertEquals(expected, new Capitalisation().capitaliseFirstCharInWordUsingSubstring(input));
    }

    @Test
    public void shouldCapitaliseWithSpecialCharacters() {
        String sentence = "look, it is not working!";
        String expected = "Look, It Is Not Working!";
        Assertions.assertEquals(expected, new Capitalisation().capitaliseFirstWordInSentenceUsingByteArray(sentence));
        Assertions.assertEquals(expected, new Capitalisation().capitaliseFirstCharInWordUsingCharArray(sentence));
        Assertions.assertEquals(expected, new Capitalisation().capitaliseFirstCharInWordUsingSubstring(sentence));
    }

}