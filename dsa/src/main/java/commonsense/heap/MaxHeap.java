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
