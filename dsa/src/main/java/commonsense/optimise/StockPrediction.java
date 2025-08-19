package commonsense.optimise;

public class StockPrediction {

    public static double findFindGreatestProfit(double[] numbers) {
        double low = numbers[0];
        double high = numbers[0];
        double total = 0;
        for (int i = 0; i < numbers.length; i++) {
            double current = numbers[i];
            if (current > high) {
                high = current;
            } else if (current < low) {
                // lowest point so start again
                low = current;
                high= current;
            }
            double currentTotal = high - low;
            if (currentTotal > total) {
                total = currentTotal;
            }
        }
        return total;
    }
}
