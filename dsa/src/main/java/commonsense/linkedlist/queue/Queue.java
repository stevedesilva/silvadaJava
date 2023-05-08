package commonsense.linkedlist.queue;

import commonsense.linkedlist.doubly.DoublyLinkedList;

import java.util.NoSuchElementException;

public class Queue<T> implements AllowedQueueMethod<T> {

    private DoublyLinkedList<T> list;


    @Override
    public void Enqueue(T value) {

    }

    @Override
    public T Dequeue() throws NoSuchElementException {
        return null;
    }

    @Override
    public T Read() throws NoSuchElementException {
        return null;
    }

    @Override
    public int Size() {
        return 0;
    }

    @Override
    public String Print() {
        return null;
    }
}
