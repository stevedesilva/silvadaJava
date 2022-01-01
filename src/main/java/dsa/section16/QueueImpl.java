package dsa.section16;

import java.util.ArrayList;
import java.util.List;

public class QueueImpl<T> implements Queue<T> {
    private List<T> values;

    public QueueImpl() {
        this.values = new ArrayList<>();
    }

    @Override
    public T remove() {
        return values.remove(0);
    }

    @Override
    public void add(T value) {
        values.add(value);
    }

    @Override
    public int size() {
        return values.size();
    }

}
