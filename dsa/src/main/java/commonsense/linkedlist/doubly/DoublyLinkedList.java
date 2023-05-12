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
        return 0;
    }

    @Override
    public Node<T> head() {
        return null;
    }

    @Override
    public Node<T> tail() {
        return null;
    }
}
