package commonsense.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SumNumbersTest {
    @Test
    public void shouldThrowExceptionWhenMinimumInputNotMetEmptyArray() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SumNumbers.outerAndInnerValuesEqualHundred(new int[]{});
        });
    }
    @Test
    public void shouldThrowExceptionWhenMinimumInputNotMetOneValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SumNumbers.outerAndInnerValuesEqualHundred(new int[]{1});
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"10,10:false","50,50:true"}, delimiter = ':')
    public void innerAndOuterValuesWorkingInwardsShouldEqual100(String input, boolean output){

    }
}