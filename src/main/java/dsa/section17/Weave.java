package dsa.section17;

import dsa.section16.Queue;
import dsa.section16.QueueImpl;

public class Weave {
    public Queue weave(Queue q1, Queue q2) {
        Queue mergedQueue = new QueueImpl();
        int iL = q1.size();
        int jL = q2.size();
        while(iL > 0 || jL > 0) {
            if(iL > 0) {
                mergedQueue.add(q1.remove());
                iL--;
            }
            if(jL > 0) {
                mergedQueue.add(q2.remove());
                jL--;
            }
        }

        return mergedQueue;
    }
}
