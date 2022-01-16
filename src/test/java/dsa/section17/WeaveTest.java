package dsa.section17;

import dsa.section16.Queue;
import dsa.section16.QueueImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class WeaveTest {
    @Test
    public void shouldWeaveQueuesOfSameLengthWithPeek() {
        Queue<String> q1 = new QueueImpl<>();
        q1.add("Hi");
        q1.add("To");
        q1.add("You");

        Queue<String> q2 = new QueueImpl<>();
        q2.add("1");
        q2.add("2");
        q2.add("3");

        Queue result = new Weave().weaveUsingPeek(q1, q2);
        Assertions.assertEquals(6, result.size());
        Assertions.assertEquals(0, q1.size());
        Assertions.assertEquals(0, q2.size());

        Assertions.assertEquals("Hi", result.remove());
        Assertions.assertEquals("1", result.remove());
        Assertions.assertEquals("To", result.remove());
        Assertions.assertEquals("2", result.remove());
        Assertions.assertEquals("You", result.remove());
        Assertions.assertEquals("3", result.remove());

    }

    @Test
    public void shouldWeaveQueuesOfSameLength() {

        Queue<String> q1 = new QueueImpl<>();
        q1.add("Hi");
        q1.add("To");
        q1.add("You");

        Queue<String> q2 = new QueueImpl<>();
        q2.add("1");
        q2.add("2");
        q2.add("3");

        Queue result = new Weave().weaveUsingSize(q1, q2);
        Assertions.assertEquals(6, result.size());
        Assertions.assertEquals(0, q1.size());
        Assertions.assertEquals(0, q2.size());

        Assertions.assertEquals("Hi", result.remove());
        Assertions.assertEquals("1", result.remove());
        Assertions.assertEquals("To", result.remove());
        Assertions.assertEquals("2", result.remove());
        Assertions.assertEquals("You", result.remove());
        Assertions.assertEquals("3", result.remove());


    }

    @Test
    public void shouldWeaveQueuesOfDifferentLength() {

        Queue<String> q1 = new QueueImpl<>();
        q1.add("1");
        q1.add("2");
        q1.add("3");

        Queue<String> q2 = new QueueImpl<>();
        q2.add("Hi");


        Queue result = new Weave().weaveUsingSize(q1, q2);
        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals(0, q1.size());
        Assertions.assertEquals(0, q2.size());

        Assertions.assertEquals("1", result.remove());
        Assertions.assertEquals("Hi", result.remove());
        Assertions.assertEquals("2", result.remove());
        Assertions.assertEquals("3", result.remove());

    }

    @Test
    public void shouldWeaveQueues() {

        Queue<String> q1 = new QueueImpl<>();
        q1.add("1");
        q1.add("2");

        Queue<String> q2 = new QueueImpl<>();
        q2.add("Hi");
        q2.add("There");


        Queue result = new Weave().weaveUsingSize(q1, q2);
        Assertions.assertEquals(4, result.size());

        Assertions.assertEquals("1", result.remove());
        Assertions.assertEquals("Hi", result.remove());
        Assertions.assertEquals("2", result.remove());
        Assertions.assertEquals("There", result.remove());

    }
}