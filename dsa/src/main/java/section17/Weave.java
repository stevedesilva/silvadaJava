package section17;


import section16.Queue;
import section16.QueueImpl;

public class Weave {
    public Queue weaveUsingSize(Queue q1, Queue q2) {
        Queue mergedQueue = new QueueImpl();
        int iL = q1.size();
        int jL = q2.size();
        while (iL > 0 || jL > 0) {
            if (iL > 0) {
                mergedQueue.add(q1.remove());
                iL--;
            }
            if (jL > 0) {
                mergedQueue.add(q2.remove());
                jL--;
            }
        }
        return mergedQueue;
    }

    public Queue weaveUsingPeek(Queue q1, Queue q2) {
        Queue mergedQueue = new QueueImpl();
        while (q1.peek() != null || q2.peek() != null) {
            if (q1.peek() != null) {
                mergedQueue.add(q1.remove());
            }
            if (q2.peek() != null) {
                mergedQueue.add(q2.remove());
            }
        }
        return mergedQueue;
    }
}
