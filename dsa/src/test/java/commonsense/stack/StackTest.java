package commonsense.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void shouldPushToStack() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        assertEquals(3,stack.size());
    }

    @Test
    public void shouldPopToStack() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        assertEquals(3,stack.size());
        assertEquals("c",stack.pop());
        assertEquals("b",stack.pop());
        assertEquals("a",stack.pop());
        assertEquals(0,stack.size());

    }

    @Test
    public void shouldPeekFromTheStack() {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        assertEquals(3,stack.size());
        assertEquals("c",stack.peek());
        assertEquals("c",stack.pop());
        assertEquals("b",stack.peek());
        assertEquals("b",stack.pop());
        assertEquals("a",stack.peek());
        assertEquals("a",stack.pop());
        assertEquals(0,stack.size());

    }

    @Test
    public void shouldNotPeekFromEmptyStack() {
        Stack<String> stack = new Stack<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.peek();
        });
    }

    @Test
    public void shouldNotPopFromEmptyStack() {
        Stack<String> stack = new Stack<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
    }

}