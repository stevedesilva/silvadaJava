package patterns.decorator.lambda.base;

public class MyBaseTest<T> implements MyBaseResult<T>,MyBaseRequest<T> {

    private T value;

    @Override
    public T get() {
        return value;
    }

    @Override
    public void execute(T t) {
        value = t;
    }
}
