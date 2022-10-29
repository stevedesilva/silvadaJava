package commonsense.queue;

public interface QueueFunctions<T> {
    void enqueue(T data);
    T dequeue();
    T read();
    int size();
}
