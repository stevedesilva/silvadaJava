package commonsense.tree.binarysearch;

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

    public TreeNode<T> search(T value, TreeNode<T> node) {
        if (node == null || node.value == value) {
            return node;
        } else if (compare(value, node.value) < 1) {
            return search(value, node.left);
        } else {
            return search(value, node.right);
        }
    }

    /*
            4
           / \
          2   5
         / \
        1   3

     */
    public TreeNode<T> insert(T value, TreeNode<T> node) {
        // base case
        // if node == null or node.left
        if (node == null || node.value == null || node.value == value) {
            if (node == null) {
                // if empty, create new node
                node = new TreeNode<>(value);
            } else if (node.value == null) {
                // if empty node value, update node with value
                node.value = value;
            }
            return node;

        } else if (compare(value, node.value) < 0) {
            if (node.left == null) {
                node.left = new TreeNode<>(value);
                return node.left;
            } else {
                return insert(value, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode<>(value);
                return node.right;
            } else {
                return insert(value, node.right);
            }
        }
    }

    public TreeNode<T> delete(T value, TreeNode<T> node) {

        if (value == null || node == null) {
            // base case
            return null;

        } else if (node.value.compareTo(value) > 0) {
            node.left = delete(value, node.left);
            return node;
        } else if (node.value.compareTo(value) < 0) {
            node.right = delete(value, node.right);
        } else if (node.value.equals(value)) {
            // if node to delete has no children, just delete it
            // if node to delete has one child, replace it with its child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                // if node to delete has two children, replace it with its successor.
                // successor is the smallest node in the right subtree
                node.right = lift(node, value, node.right);
                return node;
            }
        }
        return node;
    }
    //         50
    //       /    \
    //      /      \
    //     /        \
    //   25         75
    //   / \        / \
    // 11  33      61  89
    //    /  \    /   / \
    //   30  40  52  82  95
    //            \
    //            55

    private TreeNode<T> lift(TreeNode<T> nodeToDelete, T value, TreeNode<T> currentNode) {
        // nodeToDelete gets successor node value
        // remove successor node
        if (currentNode.left != null) {
            currentNode.left = lift(nodeToDelete,value,currentNode.left);
            return currentNode;
        }

        nodeToDelete.value = currentNode.value;
        return currentNode.right;
    }


    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

    public void PrintInOrder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            PrintInOrder(node.left);
        }
        System.out.println(node.value);
        if (node.right != null) {
            PrintInOrder(node.right);
        }
    }

    public void printPreOrder(TreeNode<T> node) {

    }

    public void printPostOrder(TreeNode<T> node) {

    }

    public T findLargestItem(TreeNode<T> root) {
        return null;
    }




}
