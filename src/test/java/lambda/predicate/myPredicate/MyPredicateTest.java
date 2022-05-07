package lambda.predicate.myPredicate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;


class MyPredicateTest {

    @Test
    public void testEnumNamePredicates() {
        final Data e1 = new Data.Builder().withId("1").withName("x").withColour("RED").build();
        final Data e2 = new Data.Builder().withId("2").withName("y").withColour("PINK").build();
        final Data e3 = new Data.Builder().withId("3").withName("z").withColour("GREEN").build();
        MyPredicate<Data> myPredicate = new MyPredicate<>();
        final Optional<Set<Data>> result =
                myPredicate.filterSet(
                        Set.of(
                                e1,
                                e2,
                                e3
                        ),
                        Set.of(
                                (d) -> d.colour.equals("GREEN"),
                                (d) -> d.id.equals("1")
                        ));
        Assertions.assertEquals(result.get(), Set.of(e1, e3));
    }

    @Test
    public void testIdentity() {
        MyPredicate<String> myPredicate = new MyPredicate<>();
        final Integer integer = myPredicate.<Integer>myIdentity(1);
        System.out.println(integer);
    }

    @Test
    public void testEnumNameBiPredicates() {
        final Data e1 = new Data.Builder().withId("1").withName("x").withColour("RED").build();
        final Data e2 = new Data.Builder().withId("2").withName("y").withColour("PINK").build();
        final Data e3 = new Data.Builder().withId("3").withName("z").withColour("GREEN").build();

        MyPredicate<Data> myPredicate = new MyPredicate<>();
        Assertions.assertEquals(true, myPredicate.compareValues(e1, e1, (a, b) -> a.equals(b)));
        Assertions.assertEquals(false, myPredicate.compareValues(e1, e2, (a, b) -> a.equals(b)));

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

        public Data(Builder builder) {
            this.id = builder.id;
            this.name = builder.name;
            this.colour = builder.colour;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", colour='" + colour + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return Objects.equals(id, data.id) &&
                    Objects.equals(name, data.name) &&
                    Objects.equals(colour, data.colour);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, colour);
        }

        static class Builder {
            String id;
            String name;
            String colour;

            public Builder() {
            }

            public Builder withId(String id) {
                this.id = id;
                return this;
            }

            public Builder withName(String name) {
                this.name = name;
                return this;
            }

            public Builder withColour(String colour) {
                this.colour = colour;
                return this;
            }

            public Data build() {
                return new Data(this);
            }

        }
    }

}