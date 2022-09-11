package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PalindromeTest {
    @ParameterizedTest
    @CsvSource(value = {"a,true","ada,true","Mom,true","kayak,true","Dad,true","not,false"})
    public void TestIsPalindromeWithFor(String input, boolean expected) {
        MatcherAssert.assertThat(Palindrome.isPalindromeUsingWhileLoop(input), Matchers.equalTo(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"a,true","ada,true","Mom,true","kayak,true","Dad,true","not,false"})
    public void TestIsPalindromeWithWhil(String input, boolean expected) {
        MatcherAssert.assertThat(Palindrome.isPalindromeUsingWhileLoop(input), Matchers.equalTo(expected));
    }
}