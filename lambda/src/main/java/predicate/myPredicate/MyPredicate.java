package predicate.myPredicate;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MyPredicate<T> {
    @FunctionalInterface
    interface MyPredicateLambda<T> {
        boolean test(T t);
    }
    @FunctionalInterface
    interface MyBiPredicateLambda<T> {
        boolean test(T t, T x);
    }

    public Optional<Set<T>> filterSet(Set<T> values, Set<MyPredicateLambda<T>> filters) {
        Set<T> result = new HashSet<>();
        values.stream().forEach(v ->
                filters.forEach(f -> {
                            if (f.test(v)) {
                                result.add(v);
                            }
                        }
                )
        );
        return Optional.ofNullable(result);
    }

    public boolean compareValues(T a, T b, MyBiPredicateLambda<T> filter) {
      return filter.test(a,b);
    }

    public <M> M myIdentity(M m) {
        return m;
    }

}
