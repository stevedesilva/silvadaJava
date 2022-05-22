package section18;

import java.util.ArrayList;
import java.util.List;

public class StackImpl<T> implements Stack<T> {

    private List<T> stack = new ArrayList<>();

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        return stack.remove(size() - 1);
    }

    @Override
    public T peek() {
        return stack.get(size() - 1);
    }

    @Override
    public int size() {
        return stack.size();
    }

}
