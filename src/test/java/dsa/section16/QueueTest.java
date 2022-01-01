package dsa.section16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    void remove() {
        Queue<Integer> queue = new QueueImpl<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        Assertions.assertEquals(4, queue.size());

        Assertions.assertEquals(1, queue.remove());
        Assertions.assertEquals(2, queue.remove());
        Assertions.assertEquals(3, queue.remove());
        Assertions.assertEquals(4, queue.remove());

        Assertions.assertEquals(0, queue.size());
    }

    @Test
    void removeFromEmptyQueue() {
        Queue<Integer> queue = new QueueImpl<>();
        Assertions.assertEquals(0, queue.size());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> queue.remove());
    }

    @Test
    void shouldAddToQueue() {
        Queue<Integer> queue = new QueueImpl<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        Assertions.assertEquals(4, queue.size());
    }

}