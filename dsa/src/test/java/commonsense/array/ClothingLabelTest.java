package commonsense.array;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ClothingLabelTest {
    @ParameterizedTest
    @CsvSource(value = {
            "Purple Shirt-Purple Shirt Size 1,Purple Shirt Size: 2,Purple Shirt Size: 3,Purple Shirt Size: 4,Purple Shirt Size: 5",
            "Green Shirt-Green Shirt Size 1,Green Shirt Size: 2,Green Shirt Size: 3,Green Shirt Size: 4,Green Shirt Size: 5",
            "Red Shirt-Red Shirt Size 1,Red Shirt Size: 2,Red Shirt Size: 3,Red Shirt Size: 4,Red Shirt Size: 5",
    }, delimiter = '-')
    public void givenInventoryList_shouldReturn(String input, String output) {
        String[] inParms = input.split(",");
        String[] expected = output.split(",");
        MatcherAssert.assertThat(new ClothingLabel().markInventory(inParms), Matchers.equalTo(expected));
    }

}