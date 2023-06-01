package commonsense.linkedlist.classic;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ClassicLinkedList<T> {
    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public ClassicLinkedList(Node<T> head) {
        this.head = head;
    }

    public ClassicLinkedList() {
    }


    public T read(int index) throws NoSuchElementException {
        Node<T> currentNode = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
            if (currentNode == null) {
                // end of list
                throw new NoSuchElementException();
            }
        }
        return currentNode.data;
    }

    public Node<T> getNode(int index) throws NoSuchElementException {
        Node<T> currentNode = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
            if (currentNode == null) {
                // end of list
                throw new NoSuchElementException();
            }
        }
        return currentNode;
    }

    public int search(T value) throws NoSuchElementException {
        Node<T> currentNode = head;
        int currentIndex = 0;
        while(currentNode != null) {
            if (currentNode.data.equals(value)) {
                return currentIndex;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }
        throw new NoSuchElementException();
    }

    public void add(int index, Node<T> nodeToAdd) throws NoSuchElementException {
        if (index == 0) {
            nodeToAdd.next = head;
            head = nodeToAdd;
            return;
        }
        int currentIdx = 0;
        Node<T> currentNode = head;
        while (currentIdx < index -1) {
            currentIdx++;
            currentNode = currentNode.next;
            if(currentNode == null && index > currentIdx) {
                throw new NoSuchElementException();
            }
        }
        nodeToAdd.next = currentNode.next;
        currentNode.next = nodeToAdd;
    }


    public void add(T value) throws NoSuchElementException {
        Node<T> nodeToAdd = new Node<>(value);
        if (head == null) {
            head = nodeToAdd;
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = nodeToAdd;
    }

    public void add(int index, T value) throws NoSuchElementException {
        Node<T> nodeToAdd = new Node<>(value);
        this.add(index,nodeToAdd);
    }

    // node -> node -> nil
    public void delete(int index) throws NoSuchElementException {
        if (index == 0) {
            head = head.next;
            return;
        }
        int currentIdx = 0;
        Node<T> currentNode = head;
        while (currentIdx < index-1) {
            currentIdx++;
            currentNode = currentNode.next;
            if (currentNode == null && index > currentIdx) {
                throw new NoSuchElementException();
            }
        }
        currentNode.next = currentNode.next.next;
    }
    // a -> b -> c -> -d -> e -> null
    public void deleteItems(Predicate<T> match) {
        Node<T> previousNode = null;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (previousNode == null) {
                // head case
                if (match.test(currentNode.data)) {
                    head = currentNode.next;
                } else {
                    previousNode = currentNode;
                }
            } else {
                // not head
                if (match.test(currentNode.data)) {
                    previousNode.next = currentNode.next;
                } else {
                    previousNode = currentNode;
                }
            }
            currentNode = currentNode.next;
        }
    }

    public String printItems() {
        StringBuilder sb = new StringBuilder();
        Node<T> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.data);
            sb.append(" -> ");
            currentNode = currentNode.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public String printItemsInReverse() {
        // if list is empty return empty string
        if (head == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.insert(0, " -> null");
        Node<T> currentNode = head;
        while (currentNode != null) {
            sb.insert(0, currentNode.data);
            currentNode = currentNode.next;
            if (currentNode != null){
                sb.insert(0, " -> ");
            }
        }
        return sb.toString();
    }
    public void reverseItems() {
        Node<T> previousNode = null;
        Node<T> currentNode = head;
        Node<T> nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;

        }
        head = previousNode;
    }
    public T readLastItem() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    public void delete(Node<T> node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            head = head.next;
            return;
        }
        Node<T> previous = null;
        Node<T> current = head;
        while (current != node) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        current.next = null;
    }

}
