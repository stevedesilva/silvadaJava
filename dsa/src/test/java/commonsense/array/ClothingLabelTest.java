package commonsense.array;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ClothingLabelTest {
    @ParameterizedTest
    @CsvSource(value = {
            "Purple Shirt-Purple Shirt Size: 1,Purple Shirt Size: 2,Purple Shirt Size: 3,Purple Shirt Size: 4,Purple Shirt Size: 5",
            "Green Shirt-Green Shirt Size: 1,Green Shirt Size: 2,Green Shirt Size: 3,Green Shirt Size: 4,Green Shirt Size: 5",
            "Red Shirt-Red Shirt Size: 1,Red Shirt Size: 2,Red Shirt Size: 3,Red Shirt Size: 4,Red Shirt Size: 5",
            "Pink Shirt,Red Shirt-Pink Shirt Size: 1,Pink Shirt Size: 2,Pink Shirt Size: 3,Pink Shirt Size: 4,Pink Shirt Size: 5,Red Shirt Size: 1,Red Shirt Size: 2,Red Shirt Size: 3,Red Shirt Size: 4,Red Shirt Size: 5",
    }, delimiter = '-')
    public void givenInventoryList_shouldReturn(String input, String output) {
        final String[] splitOutput = output.split(",");
        final String[] actual = new ClothingLabel().markInventory(input.split(","));
        MatcherAssert.assertThat(actual, Matchers.equalTo(splitOutput));
    }

}