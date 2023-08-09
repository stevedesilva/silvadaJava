package commonsense.tree.binarysearch;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

class TreeNodeTest {
    @Test
    public void shouldCreateTreeNode() {
        TreeNode<Integer> left = new TreeNode<>(5);
        TreeNode<Integer> right = new TreeNode<>(6);
        TreeNode<Integer> root = new TreeNode<>(4, left, right);
        MatcherAssert.assertThat(4, Matchers.equalTo(root.value));
        MatcherAssert.assertThat(5, Matchers.equalTo(root.left.value));
        MatcherAssert.assertThat(6, Matchers.equalTo(root.right.value));
    }

    @Test
    public void shouldSearchTreeNode() {
        TreeNode<Integer> left = new TreeNode<>(3, new TreeNode<Integer>(2), new TreeNode<Integer>(4));
        TreeNode<Integer> right = new TreeNode<>(6, null, null);
        TreeNode<Integer> root = new TreeNode<>(5, left, right);
        MatcherAssert.assertThat(2, Matchers.equalTo(root.search(2, root).value));
        MatcherAssert.assertThat(3, Matchers.equalTo(root.search(3, root).value));
        MatcherAssert.assertThat(4, Matchers.equalTo(root.search(4, root).value));
        MatcherAssert.assertThat(5, Matchers.equalTo(root.search(5, root).value));
        MatcherAssert.assertThat(6, Matchers.equalTo(root.search(6, root).value));
    }

    @Test
    public void shouldSearchTreeNodeAndNotFindValue() {
        TreeNode<Integer> left = new TreeNode<>(3, new TreeNode<Integer>(2), new TreeNode<Integer>(4));
        TreeNode<Integer> right = new TreeNode<>(6, null, null);
        TreeNode<Integer> root = new TreeNode<>(5, left, right);
        MatcherAssert.assertThat(root.search(11, root), is(nullValue()));
    }

    @Test
    public void shouldInsertTreeNodesInEmptyTree() {
        //      4
        //     / \
        //    3   5
        //   / \  / \
        //  1  2  6  7
        TreeNode<Integer> root = new TreeNode<>();
        root.insert(4, root);
        root.insert(5, root);
        root.insert(3, root);
        root.insert(6, root);
        root.insert(1, root);
        root.insert(2, root);
        root.insert(7, root);

        MatcherAssert.assertThat(1, Matchers.equalTo(root.search(1, root).value));
        MatcherAssert.assertThat(2, Matchers.equalTo(root.search(2, root).value));
        MatcherAssert.assertThat(3, Matchers.equalTo(root.search(3, root).value));
        MatcherAssert.assertThat(4, Matchers.equalTo(root.search(4, root).value));
        MatcherAssert.assertThat(5, Matchers.equalTo(root.search(5, root).value));
        MatcherAssert.assertThat(6, Matchers.equalTo(root.search(6, root).value));
        MatcherAssert.assertThat(7, Matchers.equalTo(root.search(7, root).value));
    }

    @Test
    public void shouldInsertTreeNodesInEmptyTreeInOrder() {
        //      4
        //     / \
        //    3   5
        //   / \  / \
        //  1  2  6  7
        TreeNode<Integer> root = new TreeNode<>();
        root.insert(1, root);
        root.insert(2, root);
        root.insert(3, root);
        root.insert(4, root);
        root.insert(5, root);
        root.insert(6, root);
        root.insert(7, root);

        MatcherAssert.assertThat(1, Matchers.equalTo(root.search(1, root).value));
        MatcherAssert.assertThat(2, Matchers.equalTo(root.search(2, root).value));
        MatcherAssert.assertThat(3, Matchers.equalTo(root.search(3, root).value));
        MatcherAssert.assertThat(4, Matchers.equalTo(root.search(4, root).value));
        MatcherAssert.assertThat(5, Matchers.equalTo(root.search(5, root).value));
        MatcherAssert.assertThat(6, Matchers.equalTo(root.search(6, root).value));
        MatcherAssert.assertThat(7, Matchers.equalTo(root.search(7, root).value));
    }


    @Test
    public void shouldDeleteNodeWithNoChildren() {
        //      4
        //     / \
        //    3   5
        //   / \  / \
        //  1  2     6
        TreeNode<Integer> root = new TreeNode<>();
        root.insert(4, root);
        root.insert(5, root);
        root.insert(3, root);
        root.insert(6, root);
        root.insert(1, root);
        root.insert(2, root);

        root.delete(1, root);
        MatcherAssert.assertThat(root.search(1, root), Matchers.nullValue());

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
        root.insert(50, root);
        root.insert(25, root);
        root.insert(75, root);
        root.insert(11, root);
        root.insert(33, root);
        root.insert(56, root);
        root.insert(89, root);
        root.insert(11, root);
        root.insert(30, root);
        root.insert(40, root);
        root.insert(52, root);
        root.insert(61, root);
        root.insert(95, root);

        root.delete(10, root);
        MatcherAssert.assertThat(root.search(10, root), Matchers.nullValue());
        MatcherAssert.assertThat(root.search(11, root).value, Matchers.equalTo(11));
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
        root.insert(50, root);
        root.insert(25, root);
        root.insert(75, root);
        root.insert(11, root);
        root.insert(33, root);
        root.insert(56, root);
        root.insert(89, root);
        root.insert(30, root);
        root.insert(40, root);
        root.insert(52, root);
        root.insert(61, root);
        root.insert(95, root);

        root.delete(56, root);
        MatcherAssert.assertThat(root.search(56, root), Matchers.nullValue());

        MatcherAssert.assertThat(52, Matchers.equalTo(root.search(52, root).value));
        MatcherAssert.assertThat(61, Matchers.equalTo(root.search(61, root).value));
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
        root.insert(50, root);
        root.insert(25, root);
        root.insert(75, root);
        root.insert(11, root);
        root.insert(33, root);
        root.insert(61, root);
        root.insert(89, root);
        root.insert(30, root);
        root.insert(40, root);
        root.insert(52, root);
        root.insert(82, root);
        root.insert(95, root);
        root.insert(55, root);

        root.delete(50, root);
        MatcherAssert.assertThat(root.search(50, root), Matchers.nullValue());

        MatcherAssert.assertThat(52, Matchers.equalTo(root.search(52, root).value));
        MatcherAssert.assertThat(55, Matchers.equalTo(root.search(55, root).value));

    }

    @Test
    public void shouldPrintTreeNodes() {
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
        root.insert(50, root);
        root.insert(25, root);
        root.insert(75, root);
        root.insert(11, root);
        root.insert(33, root);
        root.insert(61, root);
        root.insert(89, root);
        root.insert(30, root);
        root.insert(40, root);
        root.insert(52, root);
        root.insert(82, root);
        root.insert(95, root);
        root.insert(55, root);

        var expectedOutput = "11\n25\n30\n33\n40\n50\n52\n55\n61\n75\n82\n89\n95\n";
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // do the work
        root.PrintInOrder(root);

        // reset output stream
        System.setOut(originalOut);
        String actualOutput = outputStream.toString();
        MatcherAssert.assertThat(actualOutput, Matchers.equalTo(expectedOutput));
    }

    @Test
    public void shouldFindLargestItemInTree() {
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
        root.insert(50, root);
        root.insert(25, root);
        root.insert(75, root);
        root.insert(11, root);
        root.insert(33, root);
        root.insert(61, root);
        root.insert(89, root);
        root.insert(30, root);
        root.insert(40, root);
        root.insert(52, root);
        root.insert(82, root);
        root.insert(95, root);
        root.insert(55, root);

        final Integer largestItem = root.findLargestItem(root);
        MatcherAssert.assertThat(largestItem, Matchers.equalTo(95));
    }

}




