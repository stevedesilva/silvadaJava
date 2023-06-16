package commonsense.tree.binarysearch;

import org.hamcrest.Matchers;

import java.util.Comparator;

public class TreeNode<T extends Comparable<T>> implements Comparator<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode<T> Search(T value, TreeNode<T> node) {
        if (node == null|| node.value == value) {
            return node;
        } else if (compare(value, node.value) < 1) {
            return Search(value, node.left);
        } else {
            return Search(value, node.right);
        }
    }

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }


}
