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
    public void shouldReadLastItem() {
        ClassicLinkedList<Integer> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add(0);
        classicLinkedList.add(1);
        classicLinkedList.add(2);
        classicLinkedList.add(3);

        MatcherAssert.assertThat(classicLinkedList.readLastItem(), Matchers.equalTo(3));
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

        Assertions.assertThrows(NoSuchElementException.class, () -> new ClassicLinkedList<>(node1).read(10));

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

        Assertions.assertThrows(NoSuchElementException.class, () -> new ClassicLinkedList<>(node1).search("e"));
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

        Assertions.assertThrows(NoSuchElementException.class, () -> new ClassicLinkedList<>(node1).add(10, "z"));
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

        Assertions.assertThrows(NoSuchElementException.class, () -> classicLinkedList.read(3));
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

        Assertions.assertThrows(NoSuchElementException.class, () -> new ClassicLinkedList<>(node1).delete(10));
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

    @Test
    void shouldPrintItems() {
        ClassicLinkedList<String> list = new ClassicLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        MatcherAssert.assertThat(list.printItems(), Matchers.equalTo("a -> b -> c -> null"));
    }

    @Test
    void shouldPrintItemsInReverse() {
        ClassicLinkedList<String> list = new ClassicLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        MatcherAssert.assertThat(list.printItemsInReverse(), Matchers.equalTo("c -> b -> a -> null"));
    }

    @Test
    public void shouldReverseLinkedList() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("b");
        classicLinkedList.add("c");
        classicLinkedList.add("d");
        classicLinkedList.add("e");

        classicLinkedList.reverseItems();
        MatcherAssert.assertThat(classicLinkedList.getHead().data, Matchers.equalTo("e"));
        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo("e"));
        MatcherAssert.assertThat(classicLinkedList.read(1), Matchers.equalTo("d"));
        MatcherAssert.assertThat(classicLinkedList.read(2), Matchers.equalTo("c"));
        MatcherAssert.assertThat(classicLinkedList.read(3), Matchers.equalTo("b"));
        MatcherAssert.assertThat(classicLinkedList.read(4), Matchers.equalTo("a"));
    }

    @Test
    public void shouldGetNodeFromLinkedList() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("b");
        classicLinkedList.add("c");
        classicLinkedList.add("d");
        classicLinkedList.add("e");

        MatcherAssert.assertThat(classicLinkedList.getNode(0).data, Matchers.equalTo("a"));
        MatcherAssert.assertThat(classicLinkedList.getNode(1).data, Matchers.equalTo("b"));
        MatcherAssert.assertThat(classicLinkedList.getNode(2).data, Matchers.equalTo("c"));
        MatcherAssert.assertThat(classicLinkedList.getNode(3).data, Matchers.equalTo("d"));
        MatcherAssert.assertThat(classicLinkedList.getNode(4).data, Matchers.equalTo("e"));
    }

    @Test
    public void shouldDeleteStartNodeFromLinkedList() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("b");
        classicLinkedList.add("c");
        classicLinkedList.add("d");
        classicLinkedList.add("e");
        final Node<String> start = classicLinkedList.getNode(0);
        classicLinkedList.delete(start);


        MatcherAssert.assertThat(classicLinkedList.getHead().data, Matchers.equalTo("b"));
        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo("b"));
        MatcherAssert.assertThat(classicLinkedList.getHead().next.data, Matchers.equalTo("c"));
        MatcherAssert.assertThat(classicLinkedList.read(1), Matchers.equalTo("c"));
        MatcherAssert.assertThat(classicLinkedList.getHead().next.next.data, Matchers.equalTo("d"));
        MatcherAssert.assertThat(classicLinkedList.read(2), Matchers.equalTo("d"));
        MatcherAssert.assertThat(classicLinkedList.getHead().next.next.next.data, Matchers.equalTo("e"));
        MatcherAssert.assertThat(classicLinkedList.read(3), Matchers.equalTo("e"));
    }

    @Test
    public void shouldDeleteMidNodeFromLinkedList() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("b");
        classicLinkedList.add("c");
        classicLinkedList.add("d");
        classicLinkedList.add("e");
        final Node<String> mid = classicLinkedList.getNode(1);
        classicLinkedList.delete(mid);


        MatcherAssert.assertThat(classicLinkedList.getHead().data, Matchers.equalTo("a"));
        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo("a"));
        MatcherAssert.assertThat(classicLinkedList.getHead().next.data, Matchers.equalTo("c"));
        MatcherAssert.assertThat(classicLinkedList.read(1), Matchers.equalTo("c"));
        MatcherAssert.assertThat(classicLinkedList.getHead().next.next.data, Matchers.equalTo("d"));
        MatcherAssert.assertThat(classicLinkedList.read(2), Matchers.equalTo("d"));
        MatcherAssert.assertThat(classicLinkedList.getHead().next.next.next.data, Matchers.equalTo("e"));
        MatcherAssert.assertThat(classicLinkedList.read(3), Matchers.equalTo("e"));
    }

    @Test
    public void shouldDeleteEndNodeFromLinkedList() {
        ClassicLinkedList<String> classicLinkedList = new ClassicLinkedList<>();
        classicLinkedList.add("a");
        classicLinkedList.add("b");
        classicLinkedList.add("c");
        classicLinkedList.add("d");
        classicLinkedList.add("e");
        final Node<String> end = classicLinkedList.getNode(4);
        classicLinkedList.delete(end);


        MatcherAssert.assertThat(classicLinkedList.getHead().data, Matchers.equalTo("a"));
        MatcherAssert.assertThat(classicLinkedList.read(0), Matchers.equalTo("a"));
        MatcherAssert.assertThat(classicLinkedList.getHead().next.data, Matchers.equalTo("b"));
        MatcherAssert.assertThat(classicLinkedList.read(1), Matchers.equalTo("b"));
        MatcherAssert.assertThat(classicLinkedList.getHead().next.next.data, Matchers.equalTo("c"));
        MatcherAssert.assertThat(classicLinkedList.read(2), Matchers.equalTo("c"));
        MatcherAssert.assertThat(classicLinkedList.getHead().next.next.next.data, Matchers.equalTo("d"));
        MatcherAssert.assertThat(classicLinkedList.read(3), Matchers.equalTo("d"));
    }

}