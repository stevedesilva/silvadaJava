package commonsense.stack;

public interface StackFunctions<T> {
    void push(T value);
    T pop();
    T peek();
    int size();
}
