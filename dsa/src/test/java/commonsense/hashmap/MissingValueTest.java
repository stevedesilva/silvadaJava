package commonsense.hashmap;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class MissingValueTest {
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "the quick brown _ox jumps over the lazy dog:f",
            "the quick brown fox jumps over the lazy dog:",
            "the qu_ck brown fox jumps over the lazy dog:i"
    })
    public void shouldReturnMissingCharacter(String input, String output) {
        if (output == null) {
            output = "";
        }
        var res = MissingValue.findFirstMissingCharacter(input);
        MatcherAssert.assertThat(res, Matchers.equalTo(output));
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "the quick brown _ox jumps over the lazy dog:f",
            "the quick brown fox jumps over the lazy dog:",
            "the qu_ck brown fox _umps over the lazy dog:i,j"
    })
    public void shouldReturnMissingCharacters(String input, String output) {
        List<String> expected;
        if (output == null) {
            expected = new ArrayList<>();
        } else {
            expected = Arrays.stream(output.split(",")).collect(Collectors.toList());
        }
        var res = MissingValue.findMissingCharacters(input);
        MatcherAssert.assertThat(res, Matchers.equalTo(expected));
    }
}