package command.lambda.generic.executor;

@FunctionalInterface
public interface GenericOperation<T> {
    T execute();
}
