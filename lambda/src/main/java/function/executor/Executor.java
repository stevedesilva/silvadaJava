package function.executor;

import java.util.Set;
import java.util.function.Function;

public interface Executor{
    <T> void addFunctions(Function<T,T>... data);
    <T> void addData(T... data);
    <T> Set<T> execute();
}
