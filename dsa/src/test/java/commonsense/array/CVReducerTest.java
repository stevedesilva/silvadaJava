package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CVReducerTest {
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "doc1:doc1",
            "doc1,doc2,doc3:doc2",
            "doc1,doc2,doc3,doc4:doc3",
            "doc1,doc2,doc3,doc4,doc5:doc3",
            "doc1,doc2,doc3,doc4,doc5,doc6,doc7:doc5",
    })
    public void shouldReturnMiddleResume(String input, String expected){
        final String[] resumes = input.split(",");
        MatcherAssert.assertThat(expected, Matchers.equalTo(CVReducer.pickResume(resumes)));
    }
    @Test
    public void shouldThrowExceptionWhenMinimumNotMet(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> CVReducer.pickResume(new String[]{}));
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo(CVReducer.MINIMUM_VALUES_REQUIRED));

        exception = assertThrows(IllegalArgumentException.class, () -> CVReducer.pickResume(null));
        MatcherAssert.assertThat(exception.getMessage(), Matchers.equalTo(CVReducer.MINIMUM_VALUES_REQUIRED));
    }

}