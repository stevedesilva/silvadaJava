package commonsense.linkedlist.doubly;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public interface AllowedLinkedListMethod<T> {
    void addAtEnd(T value);
    void addByIndex(int index, T value) throws NoSuchElementException;
    void addToFront(T value);
    void deleteByIndex(int index) throws NoSuchElementException;
    void deleteFromEnd() throws NoSuchElementException;
    void deleteFromFront() throws NoSuchElementException;
    void deleteItems(Predicate<T> fn);
    String printItems();
    String printItemsInReverse();
    T readByIndex(int index) throws NoSuchElementException;
    T readFromEnd() throws NoSuchElementException;
    T readFromFront() throws NoSuchElementException;
    T removeByIndex(int index) throws NoSuchElementException;
    T removeFromEnd() throws NoSuchElementException;
    T removeFromFront() throws NoSuchElementException;
    int search(T value) throws NoSuchElementException;
    int size();
    Node<T> head();
    Node<T> tail();
    void reverseItems();
}
