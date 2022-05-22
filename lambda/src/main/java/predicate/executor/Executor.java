package predicate.executor;

import java.util.Set;
import java.util.function.Predicate;

public interface Executor<T> {
    Set<T> execute();

    void addData(T... t);

    void addPredicate(Predicate<T>... t);

}
