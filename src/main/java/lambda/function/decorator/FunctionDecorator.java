package lambda.function.decorator;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class FunctionDecorator<T, R> {


//    public Optional<Set<R>> work(Set<T> values, Set<Function<T, R>> functions) {
//        Set<R> result = new HashSet<>();
//        Function<T, R> chainedFunc = null;
////        Function<String, String> chainedFunc = (a) -> "";
//        // chain functions
//        final Function<T, R> reduce = functions.stream().reduce(null, (acc, fn) -> {
//            if (acc == null) {
//                return fn;
//            }
//            final Function<V, R> compose = acc.compose(fn);
//            return compose;
//        });
//        // apply for each value
//        values.forEach(v -> result.add(reduce.apply(v)));
//
//        return Optional.ofNullable(result);
//    }

    public static void main(String[] args) {
        Function<String, String> testFn3 = (s) -> String.format("Processed1 %s", s);
        Function<String, String> testFn2 = (s) -> String.format("Processed2 %s", s);
        Function<String, String> testFn1 = (s) -> String.format("Processed3 %s", s);

        FunctionDecorator<String,String> decorator = new FunctionDecorator<>();
        Function<String, String> add = decorator.add(testFn1, testFn2);
        add = decorator.add(add, testFn3);

//        final String res = decorator.getStringStringFunction(testFn2, testFn1, "1");
        final String res = add.apply("test");
        System.out.println(res);


    }

//    public <V> Function<T, V> chainFunctions(List<Function<T, R>> chain) {
//        Function<T,R> firstFn = chain.get(0);
//
//        chain.stream().reduce(Function.identity(),(acc,f) -> acc.andThen(f));
//
//
//
//
//        return null;
//    }

    private <V> Function<T, V>  add(Function<T, R> chain, Function<R, V> fn) {
        return chain.andThen(fn);
    }

//    private <V> V getStringStringFunction(String value, Set<Function<String, String>> fns) {
//        Function<R, V>  chainFn = null;
//        final Function<T, V> tpFunction =;
//        final V chainedFnRes = tpFunction.apply(value);
//        return chainedFnRes;
//    }
//    private <V> V getStringStringFunction(Function<T, R> testFn1, Function<R, V> testFn2, T value) {
//
//        final Function<T, V> tpFunction = testFn1.andThen(testFn2);
//        final V chainedFnRes = tpFunction.apply(value);
//        return chainedFnRes;
//    }


//    public Optional<Set<R>> work(T values, BinaryOperator<T> op) {
//        Set<T> result = new HashSet<>();
//
//        op.andThen(op);
//        Function<T, R> chainedFunc = null;
////        Function<String, String> chainedFunc = (a) -> "";
//        // chain functions
//        final Function<T, R> reduce = functions.stream().reduce(null, (acc, fn) -> {
//            if (acc == null) {
//                return fn;
//            }
//            final Function<V, R> compose = acc.compose(fn);
//            return compose;
//        });
//        // apply for each value
//        values.forEach(v -> result.add(reduce.apply(v)));
//
//        return Optional.ofNullable(result);
//    }

}
