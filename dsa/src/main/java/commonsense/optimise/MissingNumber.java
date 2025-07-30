package commonsense.optimise;

import java.util.Arrays;

public class MissingNumber {
    public static int findAlternative(int[] numbers) {
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

    public static int find(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("number array cannot be empty");
        }
        int sumActual = Arrays.stream(numbers).sum();

        // sum numbers for 0 to numbers.length
        int sumExpected = 0;
        for (int i = 0; i <= numbers.length; i++) {
            sumExpected += i;
        }

        int missingNumber = sumExpected - sumActual;
        if (missingNumber >= 0 && missingNumber < numbers.length) {
            return missingNumber;
        }
        throw new IllegalArgumentException("invalid missing number");
    }

}

