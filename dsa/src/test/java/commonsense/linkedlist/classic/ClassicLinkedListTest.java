package commonsense.linkedlist.classic;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

class ClassicLinkedListTest {

    @Test
    public void shouldCreateLinkedList() {
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node1 = new Node<>(1);
        node1.next = node2;
        node2.next = node3;
        ClassicLinkedList<Integer> classicLinkedList = new ClassicLinkedList<>(node1);

        MatcherAssert.assertThat(classicLinkedList.getHead(), Matchers.equalTo(node1));
        MatcherAssert.assertThat(classicLinkedList.getHead().next, Matchers.equalTo(node2));
        MatcherAssert.assertThat(classicLinkedList.getHead().next.next, Matchers.equalTo(node3));
    }

    @Test
    public void shouldReadIndexOfLinkedList() {
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node1 = new Node<>(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ClassicLinkedList<Integer> classicLinkedList = new ClassicLinkedList<>(node1);

        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo(node1.data));
        MatcherAssert.assertThat(classicLinkedList.read(1), Matchers.equalTo(node2.data));
        MatcherAssert.assertThat(classicLinkedList.read(2), Matchers.equalTo(node3.data));
        MatcherAssert.assertThat(classicLinkedList.read(3), Matchers.equalTo(node4.data));
    }

    @Test
    public void shouldThrowExceptionWhenReadIndexNotFoundInLinkedList() {
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node1 = new Node<>(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            new ClassicLinkedList<>(node1).read(10);
        });

    }

    @Test
    public void shouldSearchForValueInLinkedList() {
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        MatcherAssert.assertThat(new ClassicLinkedList<>(node1).search("c"), Matchers.equalTo(2));
    }

    @Test
    public void shouldThrowExceptionWhenSearchValueNotFoundInLinkedList() {
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            new ClassicLinkedList<>(node1).search("e");
        });
    }

    @Test
    public void shouldAddValueAtHeadOfLinkedList() {
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>(node1);
        final String newValue = "z";
        classicLinkedList.add(0, newValue);
        final String firstValue = classicLinkedList.read(0);
        MatcherAssert.assertThat(firstValue, Matchers.equalTo(newValue));
    }

    @Test
    public void shouldAddValueInTheMiddleOfLinkedList() {
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>(node1);
        final String newValue = "z";
        classicLinkedList.add(1, newValue);
        final String firstValue = classicLinkedList.read(1);
        MatcherAssert.assertThat(firstValue, Matchers.equalTo(newValue));
    }

    @Test
    public void shouldAddValueAtEndOfLinkedList() {
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>(node1);
        final String newValue = "z";
        classicLinkedList.add(3, newValue);
        final String firstValue = classicLinkedList.read(3);
        MatcherAssert.assertThat(firstValue, Matchers.equalTo(newValue));
    }

    @Test
    public void shouldThrowExceptionWhenAddIndexNotFoundInLinkedList() {
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            new ClassicLinkedList<>(node1).add(10, "z");
        });
    }

    // delete
    @Test
    public void shouldDeleteValueAtHeadOfLinkedList() {
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>(node1);
        classicLinkedList.delete(0);
        final String firstValue = classicLinkedList.read(0);
        MatcherAssert.assertThat(firstValue, Matchers.equalTo("b"));
    }

    @Test
    public void shouldDeleteValueFromTheMiddleOfLinkedList() {
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>(node1);
        classicLinkedList.delete(1);
        final String firstValue = classicLinkedList.read(1);
        MatcherAssert.assertThat(firstValue, Matchers.equalTo("c"));
    }

    @Test
    public void shouldDeleteValueAtEndOfLinkedList() {
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>(node1);
        classicLinkedList.delete(3);

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            classicLinkedList.read(3);
        });
        final String firstValue = classicLinkedList.read(2);
        MatcherAssert.assertThat(firstValue, Matchers.equalTo("c"));
    }

    @Test
    public void shouldThrowExceptionWhenDeleteIndexNotFoundInLinkedList() {
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            new ClassicLinkedList<>(node1).delete(10);
        });
    }

    @Test
    public void shouldAddValues() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("b");
        classicLinkedList.add("c");
        classicLinkedList.add("d");
        classicLinkedList.add("e");
        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo("a"));
        MatcherAssert.assertThat(classicLinkedList.read(1), Matchers.equalTo("b"));
        MatcherAssert.assertThat(classicLinkedList.read(2), Matchers.equalTo("c"));
        MatcherAssert.assertThat(classicLinkedList.read(3), Matchers.equalTo("d"));
        MatcherAssert.assertThat(classicLinkedList.read(4), Matchers.equalTo("e"));
    }

    @Test
    public void shouldDeleteValuesForStartOfList() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("a");
        classicLinkedList.add("c");

        classicLinkedList.deleteItems((s) ->
                s.equalsIgnoreCase("a")
        );
        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo("c"));
    }

    @Test
    public void shouldNotDeleteValuesNoPredicateMatch() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("b");
        classicLinkedList.add("c");

        classicLinkedList.deleteItems((s) ->
                s.equalsIgnoreCase("z")
        );
        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo("a"));
        MatcherAssert.assertThat(classicLinkedList.read(1), Matchers.equalTo("b"));
        MatcherAssert.assertThat(classicLinkedList.read(2), Matchers.equalTo("c"));
    }

    @Test
    public void shouldNotDeleteValuesMiddleList() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("b");
        classicLinkedList.add("c");

        classicLinkedList.deleteItems((s) ->
                s.equalsIgnoreCase("b")
        );
        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo("a"));
        MatcherAssert.assertThat(classicLinkedList.read(1), Matchers.equalTo("c"));
    }

    @Test
    public void shouldDeleteValues() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("b");
        classicLinkedList.add("a");
        classicLinkedList.add("d");
        classicLinkedList.add("a");
        classicLinkedList.deleteItems((s) ->
                s.equalsIgnoreCase("a")
        );
        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo("b"));
        MatcherAssert.assertThat(classicLinkedList.read(1), Matchers.equalTo("d"));
    }

    @Test
    public void shouldDeleteValuesUsingRegex() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("this is a password:1 that needs obfuscating");
        classicLinkedList.add("this is a password:12 that needs obfuscating");
        classicLinkedList.add("this is a password:123 that needs obfuscating");
        classicLinkedList.add("this is a password:12cae that needs obfuscating");
        classicLinkedList.add("this is a password:some_password that needs obfuscating");
        classicLinkedList.add("a");
        classicLinkedList.add("b");


        classicLinkedList.deleteItems((s) -> {
                    Pattern p = Pattern.compile("\\bpassword:[\\w]+\\b");
                    return p.matcher(s).find();
                }
        );
        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo("a"));
        MatcherAssert.assertThat(classicLinkedList.read(1), Matchers.equalTo("b"));
    }

    // reverse list
    @Test
    public void shouldReverseLinkedList() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("b");
        classicLinkedList.add("c");

        classicLinkedList.reverseItems();
//        MatcherAssert.assertThat(firstValue, Matchers.equalTo(newValue));
    }

    @Test
    public void shouldThrowExceptionWhenHasNoElementsInLinkedListDuringReverse() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();

        classicLinkedList.reverseItems();

        Assertions.assertThrows(NoSuchElementException.class, () -> {
//            new ClassicLinkedList<>(node1).add(10, "z");
        });
    }

}