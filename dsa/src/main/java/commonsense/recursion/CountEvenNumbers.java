package commonsense.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountEvenNumbers {

    public static List<Integer> countEvenNumbers(int[] array) {
        return countEvenNumbersRec(array, new ArrayList<>());
    }

    public static List<Integer> countEvenNumbersRec(int[] array, List<Integer> result) {
        if(array == null || array.length == 0){
            return result;
        }
        if (array[0] % 2 == 0) {
            result.add(array[0]);
        }
        return countEvenNumbersRec(Arrays.copyOfRange(array, 1, array.length), result);
    }
}
