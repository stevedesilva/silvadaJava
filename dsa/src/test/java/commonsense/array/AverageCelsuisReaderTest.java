package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;


class AverageCelsuisReaderTest {
    @Test
    public void shouldThrowExceptionWhenNoValuesPassToGetCelsuisAverage() {
        final IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new AverageCelsuisReader().getAverageCelsuisReading(new int[]{});
        });
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo("input parameter cannot be empty"));

    }

    @ParameterizedTest
    @CsvSource(value = {"20:-7", "40:4", "32:0", "10,20,32,40,90,100:9"}, delimiter = ':')
    public void shouldGetCelsuisAverage(String inputArrayAsStr, long expected) {
        final int[] fahrenheits = Arrays.stream(inputArrayAsStr.split(",")).map(i-> i.trim()).mapToInt(Integer::parseInt).toArray();
        MatcherAssert.assertThat(new AverageCelsuisReader().getAverageCelsuisReading(fahrenheits), Matchers.equalTo(expected));
    }
}