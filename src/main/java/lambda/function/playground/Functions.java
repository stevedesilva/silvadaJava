package lambda.function.playground;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Functions {
    public static void main(String[] args) {
        executeBuiltinFunc();
        executeMyFunction();
    }

    private static void executeBuiltinFunc() {
        System.out.println("Hello");
        BuiltinFunc mf = new BuiltinFunc();

        Function<String,String> testFn = (s) -> String.format("First %s",s);
        Function<String,String> testFn2 = (s) -> String.format("Second %s",s);

        // apply func 1 then func 2
        mf.takeInFunction(testFn.andThen(testFn2),MyNames.Steve.name());

        // apply func 2 then func 1
        mf.takeInFunction(testFn.compose(testFn2),MyNames.Steve.name());

        // apply func 1 then func 2
        mf.takeInFunction(testFn.andThen(testFn2),MyNames.Steve.name());
    }

    private static void executeMyFunction() {
        MyFunction<String,String> testMyFn = (s) -> String.format("First %s",s);
        MyFunctionTest myFunctionTest = new MyFunctionTest();
        final String foo = myFunctionTest.useMyFunction(testMyFn, "foo");
        System.out.println(foo);
    }

    enum MyNames {
        Steve(44),
        Clive(46),
        Ben(12);

        MyNames(int age) {
            this.age = age;
        }

        int age;
    }
    enum MyLocations {
        London,
        Paris,
        Madrid,
        NewMexico;
    }

    private static class BuiltinFunc {

        private void takeInBiFunction(BiFunction<String,Integer,String> fn, String v, Integer i) {
            System.out.println("fn apply = " +  fn.apply(v,i));
        }
        private void takeInFunction(Function<String,String> fn, String v) {
            System.out.println("fn apply = " +  fn.apply(v));
        }
    }

    @FunctionalInterface
    interface MyFunction<T,R> {
        R apply(T t);
    }
    private static class MyFunctionTest {
        private String useMyFunction(MyFunction<String,String> f, String someString) {
            return f.apply(someString);
        }
    }
}
