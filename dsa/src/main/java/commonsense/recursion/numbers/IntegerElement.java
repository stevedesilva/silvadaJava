package commonsense.recursion.numbers;

public class IntegerElement implements Element<Integer>{
    private Integer value;

    private IntegerElement(Integer value) {
        this.value = value;
    }

    public static IntegerElement of(Integer value) {
        return new IntegerElement(value);
    }

    public Integer get() {
        return value;
    }
}
