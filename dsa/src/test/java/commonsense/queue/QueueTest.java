package commonsense.queue;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;


class QueueTest {
    @Test
    public void shouldEnqueueToQueue() {
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        MatcherAssert.assertThat( q.size(), Matchers.equalTo(3));


        MatcherAssert.assertThat(q.dequeue(), Matchers.equalTo(3));
        MatcherAssert.assertThat(q.dequeue(), Matchers.equalTo(2));
        MatcherAssert.assertThat(q.dequeue(), Matchers.equalTo(1));
    }

    @Test
    public void shouldDequeueFromQueue() {
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        MatcherAssert.assertThat(q.dequeue(), Matchers.equalTo(3));
        MatcherAssert.assertThat(q.dequeue(), Matchers.equalTo(2));
        MatcherAssert.assertThat(q.dequeue(), Matchers.equalTo(1));
    }


    @Test
    public void shouldReadFromQueue() {
        Queue<Integer> q = new Queue<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        // read should not dequeue
        MatcherAssert.assertThat(q.read(), Matchers.equalTo(3));
        MatcherAssert.assertThat( q.size(), Matchers.equalTo(3));
    }

    @Test
    public void shouldThrowExceptionOnDequeueWhenEmpty() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            Queue<Integer> q = new Queue<>();
            q.dequeue();
        });
    }
    @Test
    public void shouldThrowExceptionOnReadWhenEmpty() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            Queue<Integer> q = new Queue<>();
            q.read();
        });
    }
}