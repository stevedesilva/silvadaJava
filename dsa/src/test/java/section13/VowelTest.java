package section13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class VowelTest {


    @ParameterizedTest
    @CsvSource({"A, 1", "a,1", "Hi there!,3", "Why?,0", "Why do you ask?,4", "aa aa aa e e v?,8"})
    public void shouldReturnVowels(String input, int expected) {
        Assertions.assertEquals(expected, new Vowel().CalculateNumberOfVowelsRegex(input));
        Assertions.assertEquals(expected, new Vowel().CalculateNumberOfVowelsIterativeUsingMap(input));
    }

    @Test
    public void oneUppercase() {
        Assertions.assertEquals(0, new Vowel().CalculateNumberOfVowelsRegex(""));
        Assertions.assertEquals(0, new Vowel().CalculateNumberOfVowelsIterativeUsingMap(""));
    }

}