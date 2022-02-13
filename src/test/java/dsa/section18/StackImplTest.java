package dsa.section18;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StackImplTest {

    @Test
    public void shouldPushToStack() {
        Stack<String> stack = new StackImpl<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        assertEquals(3,stack.size());
    }

    @Test
    public void shouldPopToStack() {
        Stack<String> stack = new StackImpl<>();
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
        Stack<String> stack = new StackImpl<>();
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
        Stack<String> stack = new StackImpl<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.peek();
        });
    }


    @Test
    public void shouldNotPopFromEmptyStack() {
        Stack<String> stack = new StackImpl<>();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
    }

}