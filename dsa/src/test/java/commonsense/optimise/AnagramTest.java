package commonsense.optimise;

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
            "abc,bac:true",
            "abc,cba:true",
            "abc,acb:true",
            "abc,xyz:false",
            "abc,ab:false",
            "abc,abcd:false",
            "abc,abca:false",
            "abc,abcb:false",
    }, delimiter = ':')
    public void shouldFindAllPossibleVariationsX(String array, boolean expected){
        final List<String> expectedAnagrams = Arrays.stream(array.split(",")).map(String::trim).collect(Collectors.toList());
        final boolean result =  Anagram.isAnagram(expectedAnagrams.get(0), expectedAnagrams.get(1));
        MatcherAssert.assertThat(result, Matchers.equalTo(expected));
    }
}