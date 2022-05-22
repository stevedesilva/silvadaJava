package function.decorator;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public class FunctionDecorator {
    public static <T> Optional<Set<T>> work(Set<T> values, List<Function<T, T>> functions) {
        Set<T> result = new HashSet<>();
        // chain functions
        final Function<T, T> reduceFunc = functions.stream().reduce(Function.<T>identity(), Function::andThen);
        // apply for each value
        values.forEach(v -> result.add(reduceFunc.apply(v)));

        return Optional.ofNullable(result);
    }
}
