package lambda.function.playground;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class OtherFunction {
    public static void main(String[] args) {
        System.out.println(OtherFunction.class.getName());
        FunctionFactory<String> ff = new FunctionFactory<>();
        OtherFunction of = new OtherFunction();
        final Optional<String> result = of.printWelcomeMessage(ff.createFn("random"), ff.createPredicate("random2"), "random3");
        System.out.println(result);
    }

    // return bi function that
    public Optional<String> printWelcomeMessage(Function<String,Optional<String>> fn, Predicate<String> isRed, String thing) {
        if (isRed.test(thing)) {
            System.out.println("Executing");
            return fn.apply(thing);
        } else {
            System.out.println("Nope");
            return Optional.empty();
        }

    }

    public static class FunctionFactory<T> {
        Predicate<T> createPredicate(T thing) {
            return  (T t)-> t.hashCode() > 1;
        }

        Function<String,Optional<String>> createFn(String bar) {
            return (it) -> Optional.ofNullable(String.format("%s %s", bar, it));
        }
    }
}


