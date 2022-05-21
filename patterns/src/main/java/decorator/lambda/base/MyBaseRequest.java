package decorator.lambda.base;

@FunctionalInterface
public interface MyBaseRequest<T> {
     void execute(T t);
}
