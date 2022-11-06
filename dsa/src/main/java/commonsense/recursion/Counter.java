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
}
