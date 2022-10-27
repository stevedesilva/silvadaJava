package commonsense.stack;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Stack<T> implements StackFunctions<T> {
    private List<T> stack;

    public Stack() {
        this.stack = new ArrayList<T>();
    }

    @Override
    public void push(T value) {
        stack.add(value);
    }

    @Override
    public T pop() {
        if(stack.size() > 1) {
            throw new NoSuchElementException();
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        if(stack.size() > 1) {
            throw new NoSuchElementException();
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public int size() {
        return stack.size();
    }
}
