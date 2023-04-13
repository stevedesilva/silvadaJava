package commonsense.linkedlist;

import commonsense.node.Node;

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
        return currentNode.value;
    }

    public int search(T value) throws NoSuchElementException {
        Node<T> currentNode = head;
        int currentIndex = 0;
        while(currentNode != null) {
            if (currentNode.value.equals(value)) {
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
                if (match.test(currentNode.value)) {
                    head = currentNode.next;
                } else {
                    previousNode = currentNode;
                }
            } else {
                // not head
                if (match.test(currentNode.value)) {
                    previousNode.next = currentNode.next;
                } else {
                    previousNode = currentNode;
                }
            }
            currentNode = currentNode.next;
        }

    }

//    public void deleteItems(List<T> items) {
//        // if shouldDelete the remove currentItem
//    }

    public void addListOfItems() {
        throw new UnsupportedOperationException();
    }

}
