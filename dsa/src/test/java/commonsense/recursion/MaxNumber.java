package commonsense.recursion;

import java.util.Arrays;

public class MaxNumber {

    public static int findMaxNumber(int[] numbers) throws IllegalArgumentException {
        if(numbers.length == 0) {
            throw new IllegalArgumentException();
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int max = findMaxNumber(Arrays.copyOfRange(numbers,1,numbers.length));
        if (numbers[0] > max) {
            return numbers[0];
        } else {
            return max;
        }
    }
}
