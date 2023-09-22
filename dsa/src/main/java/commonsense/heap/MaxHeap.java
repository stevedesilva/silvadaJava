package commonsense.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxHeap<E extends Comparable<E>> {
     private final ArrayList<E> data;

    public MaxHeap() {
        this.data = new ArrayList<>();
    }

    public E rootNode() {
        if (data.size() == 0) {
            throw new NoSuchElementException("no element found");
        }
        return data.get(0);
    }

    public E lastNode() throws NoSuchElementException {
        if (data.size() == 0) {
            throw new NoSuchElementException("no element found");
        }

        return data.get(data.size() - 1);
    }

    protected static int getParentNode(int nodeIndex) {
        //0,1,2,3,4,5,6,7,8,9,10
        //           0
        //      /          \
        //     1            2
        //    /  \        /  \
        //   3    4      5    6
        //  / \  / \    / \   / \
        // 7  8  9  10 11 12 12 14

        // 0 -> 1 2
        // 1 -> 3 4
        // 2 -> 5 6
        return (nodeIndex - 1) / 2;
    }

    protected static int  getLeftChildNode(int nodeIndex) {
        return (nodeIndex * 2) + 1;
    }
    protected static int getRightChildNode(int nodeIndex) {
        return (nodeIndex * 2) + 2;
    }

    public static void main(String[] args) {
        var x = 5;
        System.out.println(getParentNode(11));
        System.out.println(getLeftChildNode(x));
        System.out.println(getRightChildNode(x));
    }

    public void insert(E value) {
        if (value == null) {
            throw new NoSuchElementException("no element found");
        }
        if (data.size() == 0) {
            // add if empty array
            data.add(value);
        } else {
            // add to last element, then trickle up
            data.add(value);
            int currentIdx = data.size() - 1;
            // while not root node
            while (currentIdx > 0)  {
                final int parentNodeIdx = getParentNode(currentIdx);
                final E parentNodeValue = data.get(parentNodeIdx);
                final E currentNodeValue = data.get(currentIdx);

                if (currentNodeValue.compareTo(parentNodeValue) > 0) {
                    // swap

                    data.set(currentIdx, parentNodeValue);
                    data.set(parentNodeIdx, currentNodeValue);
                    // update counter
                    currentIdx = parentNodeIdx;
                } else {
                    return;
                }
            }
        }
    }

    public E remove() {
        if (data.size() == 0) {
            throw new NoSuchElementException("no element found");
        }
        E result = data.get(0);

        return result;
    }

}
