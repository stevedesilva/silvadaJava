package commonsense.tree.binarysearch;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

class TreeNodeTest {
    @Test
    public void shouldCreateTreeNode() {
        TreeNode<Integer> left = new TreeNode<>(5);
        TreeNode<Integer> right = new TreeNode<>(6);
        TreeNode<Integer> root = new TreeNode<>(4,left,right);
        MatcherAssert.assertThat(4, Matchers.equalTo(root.value));
        MatcherAssert.assertThat(5, Matchers.equalTo(root.left.value));
        MatcherAssert.assertThat(6, Matchers.equalTo(root.right.value));
    }

    @Test
    public void shouldSearchTreeNode() {
        TreeNode<Integer> left = new TreeNode<>(3, new TreeNode<Integer>(2), new TreeNode<Integer>(4));
        TreeNode<Integer> right = new TreeNode<>(6,null, null);
        TreeNode<Integer> root = new TreeNode<>(5,left,right);
        MatcherAssert.assertThat(2, Matchers.equalTo(root.Search(2, root).value));
        MatcherAssert.assertThat(3, Matchers.equalTo(root.Search(3, root).value));
        MatcherAssert.assertThat(4, Matchers.equalTo(root.Search(4, root).value));
        MatcherAssert.assertThat(5, Matchers.equalTo(root.Search(5, root).value));
        MatcherAssert.assertThat(6, Matchers.equalTo(root.Search(6, root).value));
    }

    @Test
    public void shouldInsertTreeNodesInEmptyTree() {
        //      4
        //     / \
        //    3   5
        //   / \  / \
        //  1  2  6  7
        TreeNode<Integer> root = new TreeNode<>();
        root.Insert(4, root);
        root.Insert(5, root);
        root.Insert(3, root);
        root.Insert(6, root);
        root.Insert(1, root);
        root.Insert(2, root);
        root.Insert(7, root);

        MatcherAssert.assertThat(1, Matchers.equalTo(root.Search(1, root).value));
        MatcherAssert.assertThat(2, Matchers.equalTo(root.Search(2, root).value));
        MatcherAssert.assertThat(3, Matchers.equalTo(root.Search(3, root).value));
        MatcherAssert.assertThat(4, Matchers.equalTo(root.Search(4, root).value));
        MatcherAssert.assertThat(5, Matchers.equalTo(root.Search(5, root).value));
        MatcherAssert.assertThat(6, Matchers.equalTo(root.Search(6, root).value));
        MatcherAssert.assertThat(7, Matchers.equalTo(root.Search(7, root).value));
    }

    @Test
    public void shouldInsertTreeNodesInEmptyTreeInOrder() {
        //      1
        //     / \
        //    2   null
        //   /
        //  3
        // /
        //..
        //7
        TreeNode<Integer> root = new TreeNode<>();
        root.Insert(1, root);
        root.Insert(2, root);
        root.Insert(3, root);
        root.Insert(4, root);
        root.Insert(5, root);
        root.Insert(6, root);
        root.Insert(7, root);

        MatcherAssert.assertThat(1, Matchers.equalTo(root.Search(1, root).value));
        MatcherAssert.assertThat(2, Matchers.equalTo(root.Search(2, root).value));
        MatcherAssert.assertThat(3, Matchers.equalTo(root.Search(3, root).value));
        MatcherAssert.assertThat(4, Matchers.equalTo(root.Search(4, root).value));
        MatcherAssert.assertThat(5, Matchers.equalTo(root.Search(5, root).value));
        MatcherAssert.assertThat(6, Matchers.equalTo(root.Search(6, root).value));
        MatcherAssert.assertThat(7, Matchers.equalTo(root.Search(7, root).value));
    }

}