package commonsense.optimise;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StockPredictionTest {
    /*
    {
                name: "Test with prices in ascending order simple",
                args: args{
                    prices: []float64{1.0, 2.0},
                },
                want:    1.0, // Buy at 1.0 and sell at 5.0
                wantErr: assert.NoError,
            },
            {
                name: "Test with prices in descending order simple",
                args: args{
                    prices: []float64{2.0, 1.0},
                },
                want:    0.0, // no profit possible
                wantErr: assert.NoError,
            },
            {
                name: "Test with prices in ascending order all",
                args: args{
                    prices: []float64{1.0, 2.0, 3.0, 4.0, 5.0},
                },
                want:    4.0, // Buy at 1.0 and sell at 5.0
                wantErr: assert.NoError,
            },
            {
                name: "Test with prices order",
                args: args{
                    prices: []float64{1.0, 2.0, 3.0, 4.0, 5.0, 2.0},
                },
                want:    4.0, // Buy at 1.0 and sell at 5.0
                wantErr: assert.NoError,
            },
            {
                name: "Test with normal prices",
                args: args{
                    prices: []float64{10.0, 7.0, 5.0, 8.0, 11.0, 9.0},
                },
                want:    6.0, // Buy at 5.0 and sell at 11.0
                wantErr: assert.NoError,
            },
            {
                name: "Test with prices in descending order",
                args: args{
                    prices: []float64{10.0, 9.0, 8.0, 7.0, 6.0},
                },
                want:    0.0, // No profit possible
                wantErr: assert.NoError,
            },

            {
                name: "Test with prices in ascending order with low number at the end",
                args: args{
                    prices: []float64{2.0, 3.0, 4.0, 5.0, 1.0, 2.0, 3.0},
                },
                want:    3.0, // Buy at 2.0 and sell at 5.0
                wantErr: assert.NoError,
            },
            {
                name: "Test with prices in ascending order with low number at the end",
                args: args{
                    prices: []float64{2.0, 3.0, 4.0, 5.0, 1.0, 2.0, 3.0, 10.0},
                },
                want:    9.0, // Buy at 1.0 and sell at 10.0
                wantErr: assert.NoError,
            },

            {
                name: "Test with prices in ascending order with low number at the end",
                args: args{
                    prices: []float64{2.0, 3.0, 4.0, 5.0, 1.0, 2.0, 3.0, 5.0},
                },
                want:    4.0, // Buy at 1.0 and sell at 5.0
                wantErr: assert.NoError,
            },
            {
                name: "Test with single price",
                args: args{
                    prices: []float64{10.0},
                },
                want:    0.0, // Not enough prices to calculate profit
                wantErr: assert.Error,
            },
     */
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