package commonsense.linkedlist.queue;

import java.util.NoSuchElementException;

public interface AllowedQueueMethod<T> {
    //    type AllowedQueueFunc[T comparable] interface {
//        Enqueue(value T)
//        Dequeue() (T, error)
//        Read() (T, error)
//        Size() int
//        Print() string
//    }
    void Enqueue(T value);

    T Dequeue() throws NoSuchElementException;

    T Read() throws NoSuchElementException;

    int Size();

    String Print();
}
