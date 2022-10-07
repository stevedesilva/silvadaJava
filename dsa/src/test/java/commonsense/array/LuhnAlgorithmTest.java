package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LuhnAlgorithmTest {
    @ParameterizedTest
    @CsvSource(value = {"49927398716,true", "49927398717,false","1234567812345678,false","1234567812345670,true","11111666,false"})
    public void shouldValidateCreditCard(long input, boolean expected) {
        MatcherAssert.assertThat(LuhnAlgorithm.isValidCreditCardNumber(input),Matchers.equalTo(expected));
    }
}