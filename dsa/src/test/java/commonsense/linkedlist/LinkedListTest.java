package commonsense.linkedlist;

import commonsense.node.Node;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

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
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node1 = new Node<>(1);
        node1.next = node2;
        node2.next = node3;
        LinkedList<Integer> linkedList = new LinkedList<>(node1);


        MatcherAssert.assertThat(linkedList.read(0), Matchers.equalTo(node1.value));
        MatcherAssert.assertThat(linkedList.read(1), Matchers.equalTo(node2.value));
        MatcherAssert.assertThat(linkedList.read(2), Matchers.equalTo(node3.value));
    }

}