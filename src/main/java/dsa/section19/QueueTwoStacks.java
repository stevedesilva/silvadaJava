package dsa.section19;

import dsa.section18.Stack;
import dsa.section18.StackImpl;

public class QueueTwoStacks<T> implements Queue<T> {
    private Stack<T> input;
    private Stack<T> output;

    public QueueTwoStacks() {
        input = new StackImpl();
        output = new StackImpl();
    }

    @Override
    public T remove() {
        prepOutputStack();
        return output.pop();
    }

    private void prepOutputStack() {
        while(input.size() > 0) {
             output.push(input.pop());
        }
    }

    @Override
    public void add(T value) {
       input.push(value);
    }

    @Override
    public int size() {
        prepOutputStack();
        return output.size();
    }

    @Override
    public T peek() {
        prepOutputStack();
        return output.peek();
    }
}
