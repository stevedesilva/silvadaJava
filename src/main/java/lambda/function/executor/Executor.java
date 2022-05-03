package lambda.function.executor;

import java.util.Set;
import java.util.function.Function;

public interface Executor<T,R> {
    void addFunctions(Function<T,R>... data);
    void addData(T... data);
    Set<R> execute();
}
