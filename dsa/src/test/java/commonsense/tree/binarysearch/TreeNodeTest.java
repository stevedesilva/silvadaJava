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
    public void shouldSearchTreeNodeAndNotFindValue() {
        TreeNode<Integer> left = new TreeNode<>(3, new TreeNode<Integer>(2), new TreeNode<Integer>(4));
        TreeNode<Integer> right = new TreeNode<>(6,null, null);
        TreeNode<Integer> root = new TreeNode<>(5,left,right);
        MatcherAssert.assertThat(root.Search(11, root), is(nullValue()));
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
        //      4
        //     / \
        //    3   5
        //   / \  / \
        //  1  2  6  7
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


    @Test
    public void shouldDeleteNodeWithNoChildren() {
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

        final TreeNode<Integer> delete = root.Delete(1, root);
        MatcherAssert.assertThat(Matchers.equalTo(root.Search(1, root).value),Matchers.nullValue());

    }

    @Test
    public void shouldDeleteNodeWithOneChild() {
        //         50
        //      / 	    \
        //     /         \
        //   25          75
        //   / \        /  \
        // 10   33      56    89
        //  \    /  \    / \    / \
        //  11  30  40  52 61  82  95

        TreeNode<Integer> root = new TreeNode<>();
        root.Insert(50,root);
        root.Insert(25,root);
        root.Insert(75,root);
        root.Insert(11,root);
        root.Insert(33,root);
        root.Insert(56,root);
        root.Insert(89,root);
        root.Insert(11,root);
        root.Insert(30,root);
        root.Insert(40,root);
        root.Insert(52,root);
        root.Insert(61,root);
        root.Insert(95,root);

        root.Delete(10, root);
        MatcherAssert.assertThat(root.Search(11, root).value, Matchers.equalTo(11));
        MatcherAssert.assertThat(root.Search(10, root).value, Matchers.nullValue());
    }

    @Test
    public void shouldDeleteNodeWithTwoChildren() {
        //          50
        //     /         \
        //   25          75
        //   / \        /  \
        // 11  33      56    89
        //    /  \    / \    / \
        //   30  40  52 61  82  95

        TreeNode<Integer> root = new TreeNode<>();
        root.Insert(50,root);
        root.Insert(25,root);
        root.Insert(75,root);
        root.Insert(11,root);
        root.Insert(33,root);
        root.Insert(56,root);
        root.Insert(89,root);
        root.Insert(30,root);
        root.Insert(40,root);
        root.Insert(52,root);
        root.Insert(61,root);
        root.Insert(95,root);

        final TreeNode<Integer> delete = root.Delete(56, root);
        MatcherAssert.assertThat(1, Matchers.equalTo(root.Search(56, root).value));
    }
    @Test
    public void shouldDeleteNodeWhereSuccessorNodeHasRightChild() {
        //          50
        //     /        \
        //   25         75
        //   / \        / \
        // 11  33      61  89
        //    /  \    /   / \
        //   30  40  52  82  95
        //            \
        //            55

        TreeNode<Integer> root = new TreeNode<>();
        root.Insert(50,root);
        root.Insert(25,root);
        root.Insert(75,root);
        root.Insert(11,root);
        root.Insert(33,root);
        root.Insert(61,root);
        root.Insert(89,root);
        root.Insert(30,root);
        root.Insert(40,root);
        root.Insert(52,root);
        root.Insert(82,root);
        root.Insert(95,root);

        final TreeNode<Integer> delete = root.Delete(50, root);
        MatcherAssert.assertThat(1, Matchers.equalTo(root.Search(50, root).value));
    }

}