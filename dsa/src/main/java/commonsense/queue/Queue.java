package commonsense.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Queue<T> implements QueueFunctions<T> {
    private List<T> data;

    public Queue() {
        data = new ArrayList<>();
    }

    public Queue(List<T> data) {
        this.data = new ArrayList<>(data);
    }

    @Override
    public void enqueue(T data) {
        this.data.add(data);
    }

    @Override
    public T dequeue() {
        if (size() < 1) {
            throw new NoSuchElementException();
        }
        return data.remove(size()-1);
    }

    @Override
    public T read() {
        if (size() < 1) {
            throw new NoSuchElementException();
        }
        return data.get(size()-1);
    }

    @Override
    public int size() {
        return this.data.size();
    }
}
