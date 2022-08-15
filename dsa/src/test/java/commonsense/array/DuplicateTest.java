package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;


class DuplicateTest {


    @ParameterizedTest
    @CsvSource(value={"2,2,3,4:true","1,2,3,4:false","5,5,3,4:true","1:false"},delimiter = ':')
    public void testHasDuplicates(String input, boolean output) {
        int[] arrayOfInts =  Arrays.stream(input.split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        MatcherAssert.assertThat(output,Matchers.is(new Duplicate().hasDuplicates(arrayOfInts)));
    }
}