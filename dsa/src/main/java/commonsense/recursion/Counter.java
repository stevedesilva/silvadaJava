package commonsense.recursion;

import java.util.ArrayList;
import java.util.List;

public class Counter {
    public List<Integer> count(int number) {
        List<Integer> result = new ArrayList<>();
        countRec(number, result);
        return result;
    }

    private void countRec(int number, List acc) {
        if (number == 0) {
            return;
        }
        acc.add(number);
        countRec(number - 1, acc);
    }

    public List<Integer> countEven(int low, int high) {
        List<Integer> acc = new ArrayList<>();
        countEvenRec(low,high,acc);
        return acc;
    }

    private void countEvenRec(int low, int high, List<Integer> acc) {
        if (low > high) {
            return;
        }
        acc.add(low);
        countEvenRec(low + 2, high, acc);
    }
}
