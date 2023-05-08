package commonsense.linkedlist.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    public void shouldPrintItems() {
    }

    /*
    func Test_queue_Print(t *testing.T) {
        queue := New[string]()
        queue.Enqueue("a")
        queue.Enqueue("b")
        queue.Enqueue("c")
        got := queue.Print()
        want := "[a b c]"
        if want != got {
            t.Errorf("want %s got %s", want, got)
        }
    }
    */
    @Test
    public void shouldReadQueueItems() {
    }

    /*
   func Test_queue_Read(t *testing.T) {
       queue := New[string]()
       queue.Enqueue("a")
       queue.Enqueue("b")
       queue.Enqueue("c")
       got, _ := queue.Read()
       want := "a"
       if want != got {
           t.Errorf("want %s got %s", want, got)
       }
   }
   */
    @Test
    public void shouldThrowExceptionWhenReadingEmptyQueue() {
    }

    /*
    func Test_queue_ReadEmpty(t *testing.T) {
        queue := New[string]()
        if l := queue.Size(); l != 0 {
            t.Errorf("want 0 got %d", l)
        }
    }
    */
    @Test
    public void shouldEnqueue() {
    }

    /*
   func Test_queue_Enqueue(t *testing.T) {
       queue := New[string]()
       queue.Enqueue("a")
       queue.Enqueue("b")
       queue.Enqueue("c")
       if l := queue.Size(); l != 3 {
           t.Errorf("want 0 got %d", l)
       }
       want := "[a b c]"
       if got := queue.Print(); want != got {
           t.Errorf("want %s got %s", want, got)
       }
   }

   */
    @Test
    public void shouldDequeue() {
    }
 /*
    func Test_queue_Dequeue(t *testing.T) {
	queue := New[string]()
	queue.Enqueue("a")
	queue.Enqueue("b")
	queue.Enqueue("c")
	queue.Dequeue()
	queue.Dequeue()
	if l := queue.Size(); l != 1 {
		t.Errorf("want 0 got %d", l)
	}
	want := "[c]"
	if got := queue.Print(); want != got {
		t.Errorf("want %s got %s", want, got)
	}
}
*/

    @Test
    public void shouldShowQueueSize() {
    }
    /*
func Test_queue_Size(t *testing.T) {
	queue := New[string]()
	queue.Enqueue("a")
	queue.Enqueue("b")
	queue.Enqueue("c")
	if l := queue.Size(); l != 3 {
		t.Errorf("want 0 got %d", l)
	}
}

 */
}