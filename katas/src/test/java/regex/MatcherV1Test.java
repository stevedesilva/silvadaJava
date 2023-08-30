package regex;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatcherV1Test {
    @ParameterizedTest
    @CsvSource(value = {
            "steve,steve:true",
            "steve,steven:true",
            "steve,clive:false",
            "[Ss]teve,Steve:true",
            "([Ss]teve)(\\1)(\\1),SteveSteveSteve:true",
            "Steve,steve:false"},
            delimiter = ':')
    public void shouldMatchValue(String input, Boolean expected) {
        final String[] split = input.split(",");
        String regex = split[0];
        String value = split[1];
        MatcherAssert.assertThat(MatcherV1.isMatched(regex, value), Matchers.equalTo(expected));
    }
}