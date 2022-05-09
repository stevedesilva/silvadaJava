package lambda.function.playground;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyFunction {
    public static void main(String[] args) {

        Data data = new Data(UUID.randomUUID().toString(), Name.BEN.name(), Colour.BLUE.name());

        MyFunction myFunction = new MyFunction();
        MyPredicates myPredicate = new MyPredicates();

        final Set<String> results = myFunction.processMatchedData(data, (d -> String.format("Processed %s for data(%s)", d.id, d)), Set.of(myPredicate.blueMatcher, myPredicate.redMatcher, myPredicate.nameMatcher));
        results.stream().forEach(System.out::println);


        Map<String,Integer> map = new HashMap<>();
        map.computeIfAbsent("Steve", (t) -> Name.STEVE.toString().length());
     }

    public <T, R> Set<R> processMatchedData(T data, Function<T, R> fn, Set<Predicate<T>> predicates) {
        Set<R> results = new HashSet<>();
        for (Predicate<T> p : predicates) {
            if (p.test(data)) {
                results.add(fn.apply(data));
            }
        }
        return results;
    }

    static class Data {
        String id;
        String name;
        String colour;

        private Data(String id, String name, String colour) {
            this.id = id;
            this.name = name;
            this.colour = colour;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", colour='" + colour + '\'' +
                    '}';
        }
    }

    private static class MyPredicates {
        // colour matcher
        Predicate<Data> blueMatcher = (p) -> Colour.BLUE.name().equals(p.colour);
        Predicate<Data> redMatcher = (p) -> Colour.RED.name().equals(p.colour);
        Predicate<Data> nameMatcher = (p) -> Name.BEN.name().equals(p.name);
        // name matcher

        // colour and name matcher
    }

    enum Colour {
        BLUE, GREEN, RED, PINK, INDIGO, YELLOW
    }

    enum Name {
        BEN, JO, STEVE, CLIVE, TRINA, FAY
    }
}


