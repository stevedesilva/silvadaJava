package decorator.lambda.base;

import java.util.function.Function;

public class BaseGeneric <T> implements Function<T,T> {

    public BaseGeneric() {
    }

    @Override
    public T apply(T s) {
        return s;
    }
}
