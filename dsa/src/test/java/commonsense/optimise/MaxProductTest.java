package commonsense.optimise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MaxProductTest {

    @ParameterizedTest
    @CsvSource(value = {
            "'3,-1,1',3",
            "'1,2,4,5',20",
            "'-1,1,1,1',1",
            "'-10,1,7,-9,1',90",
            "'-1,-2,-3',6",
            "'0,2,3',6",
            "'-1,0,1',0",
    })
    void findMaxProductInArray(String a1, int expected) {
        MaxProduct maxProduct = new MaxProduct();
        int[] a1Array = convertStringToIntArray(a1);
        final int result = maxProduct.findMaxProductInArray(a1Array);
        assertEquals(expected, result);
    }
    private int[] convertStringToIntArray(String a1) {
        String[] split = a1.split(",");
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

    @Test
    void testEmptyArray() {
        MaxProduct maxProduct = new MaxProduct();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            maxProduct.findMaxProductInArray(new int[]{});
        });
        assertEquals("input array cannot be less than 1 element", exception.getMessage());
    }
}

