package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

public class UnivalueSubtrees {
    int counter = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) {
            return counter;
        }

        helper(root, root.val);

        return counter;
    }

    private void helper(TreeNode node, int target) {
        if(node == null) {
            return;
        }

        if(node.val == target) {
            counter++;
        }
        helper(node.left, target);
        helper(node.right, target);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);

        Assert.assertEquals(5, countUnivalSubtrees(root));
    }
}
