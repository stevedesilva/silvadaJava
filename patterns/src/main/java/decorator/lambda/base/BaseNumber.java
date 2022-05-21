package decorator.lambda.base;

import java.util.function.Function;

public class BaseNumber implements Function<Integer,Integer> {

    public BaseNumber() {
    }

    @Override
    public Integer apply(Integer s) {
        return s;
    }

}
