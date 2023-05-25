package commonsense.linkedlist.doubly;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class DoublyLinkedList<T> implements AllowedLinkedListMethod<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;


    @Override
    public void addToFront(T value) {
        addByIndex(0, value);
    }

    @Override
    public void addAtEnd(T value) {
        addByIndex(size, value);
    }

    @Override
    public void addByIndex(int index, T value) throws NoSuchElementException {
        Node<T> node = new Node<>(value);
        if (index == 0) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.previous = node;
                head = node;
            }
            size++;
            return;
        }

        if (index == size) {
            // last element
            node.previous = tail;
            tail.next = node;
            tail = node;
            size++;
            return;
        }

        // a - b - c
        Node<T> current = head;
        int position = 0;
        // get to node before one to insert
        while (position < index - 1) {
            position++;
            current = current.next;
            if (current == null) {
                throw new NoSuchElementException("index not found");
            }
        }
        node.previous = current;
        node.next = current.next;
        current.next.previous = node;
        current.next = node;
        size++;
    }



    @Override
    public void deleteByIndex(int index) throws NoSuchElementException {
         removeByIndex(index);
    }

    @Override
    public void deleteFromEnd() throws NoSuchElementException {
        removeFromEnd();
    }

    @Override
    public void deleteFromFront() throws NoSuchElementException {
        removeFromFront();
    }

    @Override
    public void deleteItems(Predicate<T> fn) {
        Node<T> curr = head;
        while(curr != null) {
            if(fn.test(curr.data)){
              if(curr.previous == null) {
                  // head
                  head = curr.next;
                  curr.next.previous = null;
              } else if(curr.next == null) {
                  // tail
                  tail = curr.previous;
                  curr.previous.next = null;
              } else {
                  curr.previous.next = curr.next;
                  curr.next.previous = curr.previous;
              }
              size--;
            }
            curr = curr.next;
        }
    }

    @Override
    public String printItems() {
        StringBuilder sb = new StringBuilder();
        Node<T> curr = head;
        while (curr != null) {
            sb.append(curr.data);
            curr = curr.next;
            if (curr != null) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    @Override
    public T readByIndex(int index) throws NoSuchElementException {
        if (index >= size) {
            throw new NoSuchElementException("index not found");
        }
        int counter = 0;
        Node<T> current = head;
        while (counter < index) {
            current = current.next;
            counter++;
        }
        return current.data;
    }

    @Override
    public T readFromFront() throws NoSuchElementException {
        if (head != null) {
            return head.data;
        }
        throw new NoSuchElementException("index not found");
    }

    @Override
    public T readFromEnd() throws NoSuchElementException {
        if (tail != null) {
            return tail.data;
        }
        throw new NoSuchElementException("index not found");
    }

    /*
    func (d *doublyLinkedList[T]) RemoveByIndex(index int) (T, error) {
	var value T
	if index >= d.size {
		return value, errors.New("index not found")
	}

	if index == 0 {
		value = d.head.data
		d.head = d.head.next
		d.size--
		return value, nil
	}

	curr := d.head
	count := 0
	for count < index {
		count++
		curr = curr.next
	}
	if curr.next == nil {
		value = curr.data
		d.tail = curr.previous
		curr.previous.next = nil
	} else {
		value = curr.data
		curr.previous.next = curr.next
		curr.next.previous = curr.previous
	}
	d.size--
	return value, nil
}
     */
    @Override
    public T removeByIndex(int index) throws NoSuchElementException {
        if (index >= size) {
            throw new NoSuchElementException("index not found");
        }
        if (index == 0) {
            T data = head.data;
            head = head.next;
//            if (head.previous != null) {
//                head.previous = null;
//            }
            size--;
            return data;
        }
        Node<T> current = head;
        int count = 0;
        T value;
        while (count < index) {
            count++;
            current = current.next;
        }
        value = current.data;
        if (current.next == null) {
            tail = current.previous;
            current.previous.next = null;
//            if (tail.next != null) {
//                tail.next = null;
//            }
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        size--;
        return value;
    }

    @Override
    public T removeFromEnd() throws NoSuchElementException {
        return removeByIndex(size -1);
    }

    @Override
    public T removeFromFront() throws NoSuchElementException {
        return removeByIndex(0);
    }

    @Override
    public int search(T value) throws NoSuchElementException {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        throw new NoSuchElementException("index not found");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Node<T> head() {
        return head;
    }

    @Override
    public Node<T> tail() {
        return tail;
    }

    public AllowedLinkedListMethod<T> reverseItems(); {

    }
}
