package commonsense.optimise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    // stock prediction
    @ParameterizedTest
    @CsvSource(value = {
            "'5,2,8,4,3,7',true",
    })
    public void predictorTest() {
        Stock stock = new Stock();
        int[] stockPrices = {100, 200, 150, 300, 250};
        boolean result = stock.isIncreasingTriplet(stockPrices);
        assertFalse(result); // Placeholder assertion; actual logic needs to be implemented
    }
}