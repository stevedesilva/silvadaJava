package commonsense.recursion.numbers;

import java.util.List;

public class ArrayElement implements Element<List<Integer>> {
    private List<Integer> value;

    public ArrayElement(List<Integer> value) {
        this.value = value;
    }


    @Override
    public List<Integer> get() {
        return value;
    }
}
