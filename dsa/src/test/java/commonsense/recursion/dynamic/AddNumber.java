package commonsense.recursion.dynamic;

import java.util.Arrays;

public class AddNumber {
    public static int addUntilOneHundred(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        if (numbers[0] + addUntilOneHundred(Arrays.copyOfRange(numbers, 1, numbers.length)) > 100){
            return addUntilOneHundred(Arrays.copyOfRange(numbers, 1, numbers.length));
        } else {
            return numbers[0] + addUntilOneHundred(Arrays.copyOfRange(numbers, 1, numbers.length));
        }
    }
}
