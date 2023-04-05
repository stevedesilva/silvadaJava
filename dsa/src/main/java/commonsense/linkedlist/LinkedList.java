package commonsense.linkedlist;

import commonsense.node.Node;
import jdk.jshell.spi.ExecutionControl;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

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
        Node<T> nodeToAdd = new Node<>(value);
        if (index == 0) {
            nodeToAdd.next = head;
            head = nodeToAdd;
            return;
        }
        int currentIdx = 0;
        Node<T> currentNode = head;
        while (currentIdx < index -1) {
            currentIdx++;
            currentNode = currentNode.next;
            if(currentNode == null && index > currentIdx) {
                throw new NoSuchElementException();
            }
        }
        nodeToAdd.next = currentNode.next;
        currentNode.next = nodeToAdd;
    }
    // node -> node -> nil
    public void delete(int index) throws NoSuchElementException {
        if (index == 0) {
            head = head.next;
            return;
        }
        int currentIdx = 0;
        Node<T> currentNode = head;
        while (currentIdx < index-1) {
            currentIdx++;
            currentNode = currentNode.next;
            if (currentNode == null && index > currentIdx) {
                throw new NoSuchElementException();
            }
        }
        currentNode.next = currentNode.next.next;
    }

    public void deleteItems(Predicate<T> match) {
        // if shouldDelete the remove currentItem
        throw new UnsupportedOperationException();
    }

//    public void deleteItems(List<T> items) {
//        // if shouldDelete the remove currentItem
//    }

    public void addListOfItems() {
        throw new UnsupportedOperationException();
    }

}
