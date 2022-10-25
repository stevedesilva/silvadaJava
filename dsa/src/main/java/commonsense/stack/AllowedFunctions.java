package commonsense.stack;

public interface AllowedFunctions<T> {
    void push(T value);
    T pop();
    T peek();
    int size();
}
