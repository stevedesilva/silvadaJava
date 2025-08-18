package commonsense.optimise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StockPredictionTest {

    @ParameterizedTest
    @CsvSource(value={"1.0,2.0:1.0"},delimiter = ':')
    public void testFindMaximumStockIncrease(Float[] stockPrices, Float expected) {
        StockPrediction stockPrediction = new StockPrediction();

    }
}