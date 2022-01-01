package dsa.section16;

public interface Queue<T> {
    T remove();

    void add(T value);

    int size();
}
