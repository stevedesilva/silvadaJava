package commonsense.linkedlist.doubly;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class DoublyLinkedList<T> implements AllowedLinkedListMethod<T>{
    private int size;
    private Node<T> head;
    private Node<T> tail;


    @Override
    public void addAtEnd(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        node.previous = current;
        tail = node;
        size++;
    }

    @Override
    public void addByIndex(int index, T value) throws NoSuchElementException {

    }

    @Override
    public void addToFront(T value) {

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
        return null;
    }

    @Override
    public T readFromEnd() throws NoSuchElementException {
        return null;
    }

    @Override
    public T readFromFront() throws NoSuchElementException {
        return null;
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
