package commonsense.recursion.numbers;

public class IntegerElement implements Element<Integer> {
    private Integer value;

    public IntegerElement(Integer value) {
        this.value = value;
    }

    @Override
    public Integer get() {
        return value;
    }
}
