package commonsense.linkedlist.queue;

import java.util.NoSuchElementException;

public interface AllowedQueueMethod<T> {

    void Enqueue(T value);

    T Dequeue() throws NoSuchElementException;

    T Read() throws NoSuchElementException;

    int Size();

    String Print();
}
