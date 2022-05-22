package section18;


public interface Stack<T> {
    void push(T item);
    T pop();
    T peek();
    int size();
}
