package commonsense.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Printer<T> implements PrinterFunc<T> {

    private Queue<T> queue;

    public Printer() {
        queue = new Queue<>();
    }

    public Printer(T... data) {
        if (data != null && data.length > 0) {
            queue = new Queue(Arrays.asList(data));
        } else {
            queue = new Queue<>();
        }
    }

    /*
    func (p *printer[T]) Run() {
	size := p.q.Size()
	// can't use size for loop since it keeps decreasing
	for i := 0; i < size; i++ {
		data, err := p.q.Dequeue()
		if err != nil {
			continue
		}
		p.print(data)
	}
}
     */
    @Override
    public void run() {
        while (queue.size() > 0) {
            printJob(queue.dequeue());
        }
    }

    private void printJob(T data) {
        System.out.println(data);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void queuePrintJob(T document) {
        queue.enqueue(document);
    }
}
