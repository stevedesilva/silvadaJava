package commonsense.tree.binarysearch;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

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
}