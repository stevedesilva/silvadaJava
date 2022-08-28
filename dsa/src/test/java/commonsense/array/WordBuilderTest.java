package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;


class WordBuilderTest {
    @Test
    public void testBuildTwoLevelWordArray() {
        WordBuilder wb = new WordBuilder();
        final List<String> result = wb.buildTwoLevelWordArray(new char[]{'a', 'b', 'c', 'd'});
        List<String> want = List.of("ab", "ac", "ad", "ba", "bc", "bd", "ca", "cb", "cd", "da", "db", "dc");
        MatcherAssert.assertThat(result, Matchers.equalTo(want));
    }

    @Test
    public void testBuildThirdLevelWordArray() {
        WordBuilder wb = new WordBuilder();
        final List<String> result = wb.buildThirdLevelWordArray(new char[]{'a', 'b', 'c', 'd'});
        List<String> want = List.of("abc", "abd", "acb", "acd", "adb", "adc", "bac", "bad", "bca", "bcd", "bda", "bdc", "cab", "cad", "cba", "cbd", "cda", "cdb", "dab", "dac", "dba", "dbc", "dca", "dcb");
        MatcherAssert.assertThat(result, Matchers.equalTo(want));
    }
}