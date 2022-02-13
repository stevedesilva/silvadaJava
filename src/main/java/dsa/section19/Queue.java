package dsa.section19;

public interface Queue<T> {
    T remove();

    void add(T value);

    int size();

    T peek();
}
