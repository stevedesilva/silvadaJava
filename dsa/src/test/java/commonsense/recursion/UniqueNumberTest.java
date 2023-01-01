package commonsense.recursion;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UniqueNumberTest {
    /*
     70 35 15  5  1
     35 20 10  4  1
     15 10  6  3  1
      5  4  3  2  1
      1  1  1  1  1
     */
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {
            "1,1:1",
            "1,2:1",
            "1,3:1",
            "1,4:1",
            "1,5:1",

            "2,1:1",
            "2,2:2",
            "2,3:3",
            "2,4:4",
            "2,5:5",

            "3,1:1",
            "3,2:3",
            "3,3:6",
            "3,4:10",
            "3,5:15",

            "4,1:1",
            "4,2:4",
            "4,3:10",
            "4,4:20",
            "4,5:35",

            "5,1:1",
            "5,2:5",
            "5,3:15",
            "5,4:35",
            "5,5:70",
    })
    public void shouldReturnUniqueNumbers(String input, int expected) {
        final String[] inputs = input.split(",");
        int row = Integer.parseInt(inputs[0]);
        int column = Integer.parseInt(inputs[1]);
        MatcherAssert.assertThat(UniqueNumber.findUniqueNumbers(row,column), Matchers.equalTo(expected));
    }
}