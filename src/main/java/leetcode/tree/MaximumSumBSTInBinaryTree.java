package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
public class MaximumSumBSTInBinaryTree {
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postOrderTraverse(root);
        return maxSum;
    }

    private int[] postOrderTraverse(TreeNode root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 }; // {min, max, sum}, initialize min=MAX_VALUE, max=MIN_VALUE
        }

        int[] left = postOrderTraverse(root.left);
        int[] right = postOrderTraverse(root.right);
        // The BST is the tree:
        if (!(left != null             // the left subtree must be BST
            && right != null            // the right subtree must be BST
            && root.val > left[1]       // the root's key must greater than maximum keys of the left subtree
            && root.val < right[0]))    // the root's key must lower than minimum keys of the right subtree
        {
            return null;
        }

        int sum = root.val + left[2] + right[2]; // now it's a BST make `root` as root
        maxSum = Math.max(maxSum, sum);
        int min = Math.min(root.val, left[0]);
        int max = Math.max(root.val, right[1]);

        return new int[] { min, max, sum };
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode();
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        Assert.assertEquals(20, maxSumBST(root));
    }
}
