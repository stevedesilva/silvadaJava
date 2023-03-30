package commonsense.linkedlist;

import commonsense.node.Node;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    Node<T> head;

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public T read(int index) throws NoSuchElementException {
        Node<T> currentNode = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
            if (currentNode == null) {
                // end of list
                throw new NoSuchElementException();
            }
        }
        return currentNode.value;
    }

    public int search(T value) throws NoSuchElementException {
        Node<T> currentNode = head;
        int currentIndex = 0;
        while(currentNode != null) {
            if (currentNode.value.equals(value)) {
                return currentIndex;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }
        throw new NoSuchElementException();
    }

    public void add(int index, T value) throws NoSuchElementException {

    }

}
