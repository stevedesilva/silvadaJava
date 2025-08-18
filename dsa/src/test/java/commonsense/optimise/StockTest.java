package commonsense.optimise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    private final Stock stock = new Stock();

    @Test
    void testIncreasingTripletExists() {
        double[] stockPrices = {100, 200, 150, 300, 250};
        assertTrue(stock.isIncreasingTriplet(stockPrices));
    }

    @Test
    void testNoIncreasingTriplet() {
        double[] stockPrices = {300, 250, 200, 150, 100};
        assertFalse(stock.isIncreasingTriplet(stockPrices));
    }

    @Test
    void testSingleElementArray() {
        double[] stockPrices = {100};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stock.isIncreasingTriplet(stockPrices));
        assertEquals("Array must not be null or have less than 3 elements", exception.getMessage());
    }

    @Test
    void testTwoElementArray() {
        double[] stockPrices = {100, 200};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stock.isIncreasingTriplet(stockPrices));
        assertEquals("Array must not be null or have less than 3 elements", exception.getMessage());
    }

    @Test
    void testArrayWithDuplicates() {
        double[] stockPrices = {100, 100, 200, 200, 300};
        assertTrue(stock.isIncreasingTriplet(stockPrices));
    }

    @Test
    void testArrayWithNegativeNumbers() {
        double[] stockPrices = {-100, -200, -300, -400, -500};
        assertFalse(stock.isIncreasingTriplet(stockPrices));
    }

    @Test
    void testArrayWithMixedNumbers() {
        double[] stockPrices = {300, 100, 200, 150, 400};
        assertTrue(stock.isIncreasingTriplet(stockPrices));
    }

    @Test
    void testEmptyArray() {
        double[] stockPrices = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stock.isIncreasingTriplet(stockPrices));
        assertEquals("Array must not be null or have less than 3 elements", exception.getMessage());
    }

    @Test
    void testNullArray() {
        double[] stockPrices = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stock.isIncreasingTriplet(stockPrices));
        assertEquals("Array must not be null or have less than 3 elements", exception.getMessage());
    }

    @Test
    void testHasIncreasingTriplet() {
        double[] stockPrices = {100, 200, 150, 300, 250};
        double[] expected = {100, 150, 300};
        double[] result = stock.HasIncreasingTriplet(stockPrices);
        assertArrayEquals(expected, result);
    }
}