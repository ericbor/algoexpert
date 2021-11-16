package tree.topdown;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

public class MaxDepth {
    private int maxDepth;
    public int maxDepth(TreeNode root) {

        helper(root, 1);
        return maxDepth;
    }

    private void helper(TreeNode node, int currDepth) {
        if(node == null) {
            return;
        }

        if(node.left == null && node.right == null) {
            maxDepth = Math.max(maxDepth, currDepth);
        } else {
            helper(node.left, currDepth + 1);
            helper(node.right, currDepth + 1);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);

        Assert.assertEquals(4, maxDepth(root));
    }
}
