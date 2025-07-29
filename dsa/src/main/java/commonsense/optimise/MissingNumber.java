package commonsense.optimise;

public class MissingNumber {
    public static int find(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("number array cannot be empty");
        }

        throw new IllegalArgumentException();
    }
}
