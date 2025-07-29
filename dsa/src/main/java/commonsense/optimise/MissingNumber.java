package commonsense.optimise;

public class MissingNumber {
    public static int find(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("number array cannot be empty");
        }
        int n = numbers.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int number : numbers) {
            actualSum += number;
        }
        int missingNumber = expectedSum - actualSum;
        if (missingNumber >= 0 && missingNumber <= n) {
            return missingNumber;
        }


        throw new IllegalArgumentException();
    }

}
