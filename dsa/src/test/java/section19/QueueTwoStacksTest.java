package section19;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueTwoStacksTest {

    @Test
    void remove() {
        Queue<Integer> queue = new QueueTwoStacks();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        Assertions.assertEquals(4, queue.size());

        Assertions.assertEquals(Integer.valueOf(1), queue.remove());
        Assertions.assertEquals(Integer.valueOf(2), queue.remove());
        Assertions.assertEquals(Integer.valueOf(3), queue.remove());
        Assertions.assertEquals(Integer.valueOf(4), queue.remove());

        Assertions.assertEquals(0, queue.size());
    }

    @Test
    void removeFromEmptyQueue() {
        Queue<Integer> queue = new QueueTwoStacks();
        Assertions.assertEquals(0, queue.size());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> queue.remove());
    }

    @Test
    void shouldAddToQueue() {
        Queue<Integer> queue = new QueueTwoStacks();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        Assertions.assertEquals(4, queue.size());
    }

    @Test
    void shouldPeekFirstElementQueue() {
        Queue<Integer> queue = new QueueTwoStacks();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        Assertions.assertEquals(Integer.valueOf(1), queue.peek());

        queue.remove();
        Assertions.assertEquals(Integer.valueOf(2), queue.peek());
    }

}