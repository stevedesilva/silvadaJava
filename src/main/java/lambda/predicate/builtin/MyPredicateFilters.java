package lambda.predicate.builtin;

import java.util.HashSet;
import java.util.Set;
import java.util.Optional;
import java.util.function.Predicate;

public class MyPredicateFilters<T> {

    public Optional<Set<T>> filterSet(Set<T> values, Set<Predicate<T>> filters) {
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

}
