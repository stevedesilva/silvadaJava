package commonsense.recursion.dynamic;

import java.util.Arrays;

public class AddNumber {
    public static int addUntilOneHundred(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        final int tailSum = addUntilOneHundred(Arrays.copyOfRange(numbers, 1, numbers.length));
        if (numbers[0] + tailSum > 100){
            return tailSum;
        } else {
            return numbers[0] + tailSum;
        }
    }
}
