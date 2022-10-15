package commonsense.hashmap;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MissingValueTest {
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "the quick brown _ox jumps over the lazy dog:f",
            "the quick brown fox jumps over the lazy dog:",
            "the qu_ck brown fox jumps over the lazy dog:i"
    })
    public void shouldReturnMissingCharacters(String input, String output) {
        if (output == null) {
            output = "";
        }
        var res = MissingValue.findFirstMissingCharacter(input);
        MatcherAssert.assertThat(res, Matchers.equalTo(output));
    }
}