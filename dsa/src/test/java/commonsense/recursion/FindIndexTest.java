package commonsense.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FindIndexTest {
   @Test
    public void shouldThrowExceptionIfCharNotFoundInString() {
       Assertions.assertThrows(IllegalArgumentException.class, () -> {
           FindIndex.findFirstIndex("ssss",'c');
       });
    }

    @ParameterizedTest
    @CsvSource("a,1")
    public void shouldFindFirstIndexForXInString(String input, int index) {

    }
}