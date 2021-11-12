package leetcode.easy.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
public class MinAbsoluteDifferenceInBST {

    int smallest = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return smallest;
        }

        getMinimumDifference(root.left);

        if (prev != null) {
            smallest = Math.min(smallest, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return smallest;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        if (prev != null) {
            smallest = Math.min(smallest, node.val - prev);
        }
        prev = node.val;

        inorder(node.right);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.right = new TreeNode(701);

        root.left.right = new TreeNode(227);
        root.right.right = new TreeNode(911);

        Assert.assertEquals(9, getMinimumDifference(root));
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Assert.assertEquals(1, getMinimumDifference(root));
    }
}
