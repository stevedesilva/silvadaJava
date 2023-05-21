package commonsense.linkedlist.doubly;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class DoublyLinkedList<T> implements AllowedLinkedListMethod<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;


    @Override
    public void addToFront(T value) {
        addByIndex(0, value);
    }

    @Override
    public void addAtEnd(T value) {
        addByIndex(size, value);
    }

    @Override
    public void addByIndex(int index, T value) throws NoSuchElementException {
        Node<T> node = new Node<>(value);
        if (index == 0) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.previous = node;
                head = node;
            }
            size++;
            return;
        }

        if (index == size) {
            // last element
            node.previous = tail;
            tail.next = node;
            tail = node;
            size++;
            return;
        }

        // a - b - c
        Node<T> current = head;
        int position = 0;
        // get to node before one to insert
        while (position < index - 1) {
            position++;
            current = current.next;
            if (current == null) {
                throw new NoSuchElementException("index not found");
            }
        }
        node.previous = current;
        node.next = current.next;
        current.next.previous = node;
        current.next = node;
        size++;
    }



    @Override
    public void deleteByIndex(int index) throws NoSuchElementException {

    }

    @Override
    public void deleteFromEnd() throws NoSuchElementException {

    }

    @Override
    public void deleteFromFront() throws NoSuchElementException {

    }

    @Override
    public void deleteItems(Predicate<T> fn) {

    }

    @Override
    public List<T> printItems() {
        return null;
    }

    @Override
    public T readByIndex(int index) throws NoSuchElementException {
        if (index >= size) {
            throw new NoSuchElementException("index not found");
        }
        int counter = 0;
        Node<T> current = head;
        while (counter < index) {
            current = current.next;
            counter++;
        }
        return current.data;
    }

    @Override
    public T readFromFront() throws NoSuchElementException {
        if (head != null) {
            return head.data;
        }
        throw new NoSuchElementException("index not found");
    }

    @Override
    public T readFromEnd() throws NoSuchElementException {
        if (tail != null) {
            return tail.data;
        }
        throw new NoSuchElementException("index not found");
    }

    @Override
    public T removeByIndex(int index) throws NoSuchElementException {
        return null;
    }

    @Override
    public T removeFromEnd() throws NoSuchElementException {
        return null;
    }

    @Override
    public T removeFromFront() throws NoSuchElementException {
        return null;
    }

    @Override
    public T search(T value) throws NoSuchElementException {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Node<T> head() {
        return head;
    }

    @Override
    public Node<T> tail() {
        return tail;
    }
}
