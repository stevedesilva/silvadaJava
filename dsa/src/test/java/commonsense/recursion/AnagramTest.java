package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

class AnagramTest {

    @ParameterizedTest
    @CsvSource(value = {"a:a","ab:ab,ba","abc:abc,bac,acb,acb,cab,cba"}, delimiter = ':')
    public void shouldFindAllPossibleVariations(String word, String expected){
        final List<String> expectedAnagrams = Arrays.asList(expected.split(","));
        final List<String> result = Anagram.findAllPossibleAnagrams(word);
        MatcherAssert.assertThat(result,Matchers.equalTo(expectedAnagrams));
    }

}