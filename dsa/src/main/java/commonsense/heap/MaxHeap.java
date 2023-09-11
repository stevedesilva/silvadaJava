package commonsense.heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MaxHeap<E> {
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

    private int getParentNode(int nodeIndex) {
        return 0;
    }

    private int getLeftChildNode(int nodeIndex) {
        return 0;
    }
    private int getRightChildNode(int nodeIndex) {
        return 0;
    }

    public void insert(E value) {
        data.add(value);

    }

    public E remove() {
        if (data.size() == 0) {
            throw new NoSuchElementException("no element found");
        }
        E result = data.get(0);
//        data.set(0, data.get(data.size() - 1));
//        data.remove(data.size() - 1);
//        int index = 0;
//        int leftIndex = 2 * index + 1;
//        int rightIndex = 2 * index + 2;
//        while (compare(data.get(index), data.get(leftIndex)) > 0 || compare(data.get(index), data.get(rightIndex)) > 0) {
//            if (compare(data.get(leftIndex), data.get(rightIndex)) < 0) {
//                swap(index, leftIndex);
//                index = leftIndex;
//            } else {
//                swap(index, rightIndex);
//                index = rightIndex;
//            }
//            leftIndex = 2 * index + 1;
//            rightIndex = 2 * index + 2;
//        }
        return result;
    }


    //        data.add(value);
//        int index = data.size() - 1;
//        int parentIndex = (index - 1) / 2;
//        while (compare(data.get(index), data.get(parentIndex)) < 0) {
//            swap(index, parentIndex);
//            index = parentIndex;
//            parentIndex = (index - 1) / 2;
//        }
}
