package commonsense.tree.binarysearch;

import org.hamcrest.Matchers;

import java.util.Comparator;

public class TreeNode<T extends Comparable<T>> implements Comparator<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode() {
    }

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
/*
        4
       / \
      2   5
     / \
    1   3
       
 */
    public TreeNode<T> Insert(T value, TreeNode<T> node) {
        // base case
        // if node == null or node.left

        if (node == null || node.value == null || node.value == value) {
            if (node == null ) {
                // if empty, create new node
                node = new TreeNode<>(value);
            } else if (node.value == null) {
                // if empty node value, update node with value
                node.value = value;
            }
            return node;
        } else if (compare(value, node.value) < 1) {
            if (node.left == null) {
                node.left = new TreeNode<>(value);
                return node.left;
            } else {
                return Insert(value, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode<>(value);
                return node.right;
            } else {
                return Insert(value, node.right);
            }
        }
    }

    public TreeNode<T> Delete(T value, TreeNode<T> node) {
        // if node to delete has no children, just delete it
        // if node to delete has one child, replace it with its child
        // if node to delete has two children, replace it with its successor
        // successor is the smallest node in the right subtree
        return null;
    }


    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }


}
