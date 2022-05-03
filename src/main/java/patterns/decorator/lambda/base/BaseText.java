package patterns.decorator.lambda.base;

import java.util.function.Function;

public class BaseText implements Function<String,String> {

    public BaseText() {
    }

    @Override
    public String apply(String s) {
        return s;
    }
}
