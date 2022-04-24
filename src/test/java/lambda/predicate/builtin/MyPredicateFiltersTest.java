package lambda.predicate.builtin;

import lambda.predicate.builtin.MyPredicateFilters;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class MyPredicateFiltersTest {

    @Test
    public void testColourPredicates() {
        final Set<String> colours = Arrays.stream(ColourData.Colour.values()).map(c -> c.name()).collect(Collectors.toSet());
        MyPredicateFilters<String> myPredicateFilters = new MyPredicateFilters<>();
        final Optional<Set<String>> result = myPredicateFilters.filterSet(colours, Set.of(ColourData.isBlue, ColourData.isRed, ColourData.isGreen));
        Assertions.assertEquals(result.get(), Set.of("BLUE", "RED", "GREEN"));
    }

    @Test
    public void testNamePredicates() {
        final Set<String> colours = Arrays.stream(NameData.NAME.values()).map(c -> c.name()).collect(Collectors.toSet());
        MyPredicateFilters<String> myPredicateFilters = new MyPredicateFilters<>();
        final Optional<Set<String>> result = myPredicateFilters.filterSet(colours, Set.of(NameData.isWill, NameData.isSteve, NameData.isClive));
        Assertions.assertEquals(result.get(), Set.of("WILL", "STEVE", "CLIVE"));
    }

    @Test
    public void testEnumNamePredicates() {
        MyPredicateFilters<NameData.NAME> myPredicateFilters = new MyPredicateFilters<>();
        final Optional<Set<NameData.NAME>> result =
                myPredicateFilters.filterSet(
                        Arrays.stream(NameData.NAME.values()).collect(Collectors.toSet()),
                        Set.of(
                                NameData.isStevePredicate,
                                NameData.greaterThen10
                ));
        Assertions.assertEquals(result.get(), Set.of(NameData.NAME.STEVE,NameData.NAME.CLIVE));
    }


    public static class ColourData {
        public enum Colour {
            RED, BLUE, GREEN, PURPLE
        }

        static Predicate<String> isBlue = (t) -> Colour.BLUE.name().equals(t);
        static Predicate<String> isRed = (t) -> Colour.RED.name().equals(t);
        static Predicate<String> isGreen = (t) -> Colour.GREEN.name().equals(t);
    }

    public static class NameData {

        public enum NAME {
            STEVE(10), CLIVE(20), WILL(2), PETER(6), GRIMES(9);

            int age;

            NAME(int age) {
                this.age = age;
            }
        }

        static Predicate<String> isSteve = (name) -> name.equals(NameData.NAME.STEVE);
        static Predicate<String> isWill = (name) -> name.equals(NAME.WILL);
        static Predicate<String> isClive = (name) -> name.equals(NAME.CLIVE);
        static Predicate<NAME> greaterThen10 = (name) -> name.age > 10;
        static Predicate<NAME> isStevePredicate = (name) -> name.equals(NameData.NAME.STEVE);

    }

}