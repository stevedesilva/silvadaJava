package commonsense.stack;


import java.util.ArrayList;
import java.util.List;

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
        return stack.remove(stack.size() - 1);
    }

    @Override
    public T peek() {
        return stack.get(stack.size() - 1);
    }

    @Override
    public int size() {
        return stack.size();
    }
}
