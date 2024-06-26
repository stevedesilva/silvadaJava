package commonsense.tree.heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MinHeap<E extends Comparable<E>> {
    private final ArrayList<E> data;

    public MinHeap() {
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

    private int rootNodeIndex() throws NoSuchElementException {
        if (data.size() == 0) {
            throw new NoSuchElementException("no element found");
        }
        return 0;
    }

    private int lastNodeIndex() throws NoSuchElementException {
        if (data.size() == 0) {
            throw new NoSuchElementException("no element found");
        }
        return data.size() - 1;
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

    protected static int getLeftChildNode(int nodeIndex) {
        return (nodeIndex * 2) + 1;
    }

    protected static int getRightChildNode(int nodeIndex) {
        return (nodeIndex * 2) + 2;
    }

    public void insert(E value) {
        if (value == null) {
            throw new NoSuchElementException("no element provided");
        }
        data.add(value);
        int newNodeIndex = data.size() - 1;
        while (newNodeIndex > 0
                && data.get(newNodeIndex).compareTo(data.get(getParentNode(newNodeIndex))) < 0) {

            int parentNodeIdx = getParentNode(newNodeIndex);
            final E parentElement = data.get(parentNodeIdx);
            final E currentElement = data.get(newNodeIndex);
            data.set(newNodeIndex, parentElement);
            data.set(parentNodeIdx, currentElement);
            newNodeIndex = parentNodeIdx;
        }
    }

    public E delete() throws NoSuchElementException {
        if (data.size() == 0) {
            throw new NoSuchElementException("no element found");
        }

        E rootNode = rootNode();
        E lastItem = data.remove(lastNodeIndex());
        if (data.size() > 0) {
            data.set(rootNodeIndex(), lastItem);
            int newNodeIndex = 0;
            while (hasChildren(newNodeIndex)) {
                int indexOfSmallestChild = findIndexOfSmallestChild(newNodeIndex);
                final E childValue = data.get(indexOfSmallestChild);
                final E currentValue = data.get(newNodeIndex);
                if (childValue.compareTo(currentValue) < 0) {
                    data.set(newNodeIndex, childValue);
                    data.set(indexOfSmallestChild, currentValue);
                    newNodeIndex = indexOfSmallestChild;
                } else {
                    break;
                }
            }
        }

        return rootNode;
    }

    private int findIndexOfSmallestChild(int currentIndex) {
        final int leftChildNodeIdx = getLeftChildNode(currentIndex);
        final int rightChildNodeIdx = getRightChildNode(currentIndex);

        boolean leftChildNodeExist = leftChildNodeIdx <= data.size() - 1;
        boolean rightChildNodeExist = rightChildNodeIdx <= data.size() - 1;
        if (leftChildNodeExist & !rightChildNodeExist) {
            return leftChildNodeIdx;
        } else if (rightChildNodeExist & !leftChildNodeExist) {
            return rightChildNodeIdx;
        } else {
            final E leftValue = data.get(leftChildNodeIdx);
            final E rightValue = data.get(rightChildNodeIdx);
            if (leftValue.compareTo(rightValue) < 0) {
                return leftChildNodeIdx;
            } else {
                return rightChildNodeIdx;
            }
        }
    }

    private boolean hasChildren(int currentIndex) {
        boolean leftChildNodeExist = getLeftChildNode(currentIndex) <= data.size() - 1;
        boolean rightChildNodeExist = getRightChildNode(currentIndex) <= data.size() - 1;
        return leftChildNodeExist || rightChildNodeExist;
    }
}
