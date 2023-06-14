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
        TreeNode<Integer> leftChild = new TreeNode<>(1);
        TreeNode<Integer> rightChild = new TreeNode<>(12);
        TreeNode<Integer> left = new TreeNode<>(5,leftChild,null);
        TreeNode<Integer> right = new TreeNode<>(6,null, rightChild);
        TreeNode<Integer> root = new TreeNode<>(4,left,right);
        MatcherAssert.assertThat(1, Matchers.equalTo(root.Search(1, root).value));
        MatcherAssert.assertThat(12, Matchers.equalTo(root.Search(12, root).value));
        MatcherAssert.assertThat(5, Matchers.equalTo(root.Search(5, root).value));
        MatcherAssert.assertThat(6, Matchers.equalTo(root.Search(6, root).value));
        MatcherAssert.assertThat(4, Matchers.equalTo(root.Search(4, root).value));
//        MatcherAssert.assertThat(Matchers.equalTo(root.Search(98, root)), is(nullValue()));
    }

}