package commonsense.optimise;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class StockPredictionTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1.0, 2.0: 1.0",
            "2.0, 1.0: 0.0",
            "1.0, 2.0, 3.0, 4.0, 5.0:4.0",
            "1.0, 2.0, 3.0, 4.0, 5.0, 2.0:4.0",
            "10.0, 7.0, 5.0, 8.0, 11.0, 9.0:6.0",
            "10.0, 9.0, 8.0, 7.0, 6.0:0.0",
            "2.0, 3.0, 4.0, 5.0, 1.0, 2.0, 3.0:3.0",
            "2.0, 3.0, 4.0, 5.0, 1.0, 2.0, 3.0, 10.0:9.0",
            "2.0, 3.0, 4.0, 5.0, 1.0, 2.0, 3.0, 5.0:4.0",
            "10.0: 0.0" // Not enough prices to calculate profit
    }, delimiter = ':')
    public void testFindMaximumStockIncrease(String stockPrices, Double expected) {
        final double[] numbers = Arrays.stream(stockPrices.split(",")).mapToDouble(Double::valueOf).toArray();
        final double result = StockPrediction.findFindGreatestProfit(numbers);
        MatcherAssert.assertThat(expected, Matchers.equalTo(result));
    }
}