package commonsense.stack;

import java.util.NoSuchElementException;

public interface StackFunctions<T> {
    void push(T value);
    T pop() throws NoSuchElementException;
    T peek() throws NoSuchElementException;
    int size();
}
