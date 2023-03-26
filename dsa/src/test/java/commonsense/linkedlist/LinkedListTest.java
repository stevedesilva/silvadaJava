package commonsense.linkedlist;

import commonsense.node.Node;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class LinkedListTest {

    @Test
    public void shouldCreateLinkedList(){
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node1 = new Node<>(1);
        node1.next = node2;
        node2.next = node3;
        LinkedList<Integer> linkedList = new LinkedList<>(node1);

        MatcherAssert.assertThat(linkedList.head, Matchers.equalTo(node1));
        MatcherAssert.assertThat(linkedList.head.next, Matchers.equalTo(node2));
        MatcherAssert.assertThat(linkedList.head.next.next, Matchers.equalTo(node3));
    }

    @Test
    public void shouldReadIndexOfLinkedList(){
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node1 = new Node<>(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        LinkedList<Integer> linkedList = new LinkedList<>(node1);

        MatcherAssert.assertThat(linkedList.read(0), Matchers.equalTo(node1.value));
        MatcherAssert.assertThat(linkedList.read(1), Matchers.equalTo(node2.value));
        MatcherAssert.assertThat(linkedList.read(2), Matchers.equalTo(node3.value));
        MatcherAssert.assertThat(linkedList.read(3), Matchers.equalTo(node4.value));
    }

    @Test
    public void shouldThrowExceptionWhenReadIndexNotFoundInLinkedList(){
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node1 = new Node<>(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            new LinkedList<>(node1).read(10);
        });

    }

    @Test
    public void shouldSearchForValueInLinkedList(){
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        MatcherAssert.assertThat(new LinkedList<>(node1).search("c"), Matchers.equalTo(2));
    }

    @Test
    public void shouldThrowExceptionWhenSearchValueNotFoundInLinkedList(){
        Node<String> node4 = new Node<>("d");
        Node<String> node3 = new Node<>("c");
        Node<String> node2 = new Node<>("b");
        Node<String> node1 = new Node<>("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Assertions.assertThrows(NoSuchElementException.class, () -> {
            new LinkedList<>(node1).search("e");
        });
    }






}