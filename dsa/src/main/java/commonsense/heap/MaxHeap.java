package commonsense.heap;

import java.util.ArrayList;
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
        lastNode();
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

    public E delete() throws NoSuchElementException {
        //           0
        //      /          \
        //     1            2
        //    /  \        /  \
        //   3    4      5    6
        //  / \  / \    / \   / \
        // 7  8  9  10 11 12 12 14


        // move last node into root node position
        E rootNode = rootNode();
        // remove last node and store value in root
        E lastItem = data.remove(lastNodeIndex());
        data.set(rootNodeIndex(),lastItem);
        // trickle to root node down into its proper place

//        if (data.size() == 0) {
//            throw new NoSuchElementException("no element found");
//        }
//        E removedItem = data.get(0);
//        int currentIndex = 0;
//        int indexToRemove = currentIndex;
//        // parent has a child
//        while (hasChildren(currentIndex)) {
//            int indexOfLargestChild = findIndexOfLargestChild(currentIndex);
//            indexToRemove = indexOfLargestChild;
//            if (hasChildren(indexOfLargestChild)){
//                // update new parent
//                data.set(currentIndex,data.get(indexOfLargestChild));
//                // update largest child
//                currentIndex = indexOfLargestChild;
//            } else {
//                data.set(currentIndex,data.get(indexOfLargestChild));
//                break;
//            }
//        }
//        // index to remove
//        data.remove(indexToRemove);


        return rootNode;
    }
//    public E delete() {
//        //           0
//        //      /          \
//        //     1            2
//        //    /  \        /  \
//        //   3    4      5    6
//        //  / \  / \    / \   / \
//        // 7  8  9  10 11 12 12 14
//
//
//        // move last node into root node position
//
//        // trickle to root node down into its proper place
//
//        if (data.size() == 0) {
//            throw new NoSuchElementException("no element found");
//        }
//        E removedItem = data.get(0);
//        int currentIndex = 0;
//        int indexToRemove = currentIndex;
//        // parent has a child
//        while (hasChildren(currentIndex)) {
//            int indexOfLargestChild = findIndexOfLargestChild(currentIndex);
//            indexToRemove = indexOfLargestChild;
//            if (hasChildren(indexOfLargestChild)){
//                // update new parent
//                data.set(currentIndex,data.get(indexOfLargestChild));
//                // update largest child
//                currentIndex = indexOfLargestChild;
//            } else {
//                data.set(currentIndex,data.get(indexOfLargestChild));
//                break;
//            }
//        }
//        // index to remove
//        data.remove(indexToRemove);
//
//
//        return removedItem;
//    }

    private int findIndexOfLargestChild(int currentIndex) {
        final int leftChildNodeIdx = getLeftChildNode(currentIndex);
        final int rightChildNodeIdx = getRightChildNode(currentIndex);

        boolean leftChildNodeExist = leftChildNodeIdx <= data.size()-1;
        boolean rightChildNodeExist = rightChildNodeIdx <= data.size()-1;
        if (leftChildNodeExist & !rightChildNodeExist) {
            return leftChildNodeIdx;
        }else if (rightChildNodeExist & !leftChildNodeExist) {
            return rightChildNodeIdx;
        } else {
            final E leftValue = data.get(leftChildNodeIdx);
            final E rightValue = data.get(rightChildNodeIdx);
            if (leftValue.compareTo(rightValue) > 0) {
                return leftChildNodeIdx;
            } else {
                return rightChildNodeIdx;
            }
        }

    }

    private boolean hasChildren(int currentIndex) {
        boolean leftChildNodeExist = getLeftChildNode(currentIndex) <= data.size()-1;
        boolean rightChildNodeExist = getRightChildNode(currentIndex) <= data.size()-1;
        return leftChildNodeExist || rightChildNodeExist;
    }

}
