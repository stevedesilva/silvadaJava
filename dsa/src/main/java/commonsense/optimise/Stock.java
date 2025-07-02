package commonsense.optimise;

public class Stock {
    // stock prediction
    public boolean isIncreasingTriplet(double[] stockPrices) {
        // Check for null or empty array
        if (stockPrices == null || stockPrices.length < 3) {
            throw new IllegalArgumentException("Array must not be null or have less than 3 elements");
        }

        double lowestPrice = stockPrices[0];
        double middlePrice = Integer.MAX_VALUE;

        for (int i = 0; i < stockPrices.length; i++) {
            double price = stockPrices[i];
            if (price <= lowestPrice) {
                lowestPrice = price;
            } else if (price <= middlePrice) {
                middlePrice = price;
            } else {
                // Found a price greater than both lowest and middle prices
                return true;
            }
        }

        return false;
    }
}
