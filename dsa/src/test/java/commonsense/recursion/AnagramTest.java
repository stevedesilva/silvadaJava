package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class AnagramTest {

    @ParameterizedTest
    @CsvSource(value = {
            "a:a",
            "ab:ab,ba",
            "abc:abc,bac,bca,acb,cab,cba",
            "abcd:abcd, bacd, bcad, bcda, acbd, cabd, cbad, cbda, acdb, cadb, cdab, cdba, abdc, badc, bdac, bdca, adbc, dabc, dbac, dbca, adcb, dacb, dcab, dcba",
    }, delimiter = ':')
    public void shouldFindAllPossibleVariations(String word, String expected){
        final List<String> expectedAnagrams = Arrays.stream(expected.split(",")).map(String::trim).collect(Collectors.toList());
        final List<String> result = Anagram.findAllPossibleAnagrams(word);
        MatcherAssert.assertThat(result,Matchers.equalTo(expectedAnagrams));
    }
    @ParameterizedTest
    @CsvSource(value = {
            "abc:abc,bac,bca,acb,cab,cba",
    }, delimiter = ':')
    public void shouldFindAllPossibleVariationsX(String word, String expected){
        final List<String> expectedAnagrams = Arrays.stream(expected.split(",")).map(String::trim).collect(Collectors.toList());
        final List<String> result = Anagram.findAllPossibleAnagrams(word);
        MatcherAssert.assertThat(result,Matchers.equalTo(expectedAnagrams));
    }

}