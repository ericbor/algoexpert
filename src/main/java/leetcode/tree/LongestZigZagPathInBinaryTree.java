package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
public class LongestZigZagPathInBinaryTree {
    int longestZigZag = 0;
    public int longestZigZag(TreeNode root) {
        helper(root, true, 0);
        helper(root, false, 0);

        return longestZigZag;
    }

    private void helper(TreeNode root, boolean isLeft, int currZigZag) {
        if(root == null) {
            return;
        }
        longestZigZag = Math.max(longestZigZag, currZigZag);

        if(isLeft) {
            helper(root.left, false, currZigZag + 1);
            helper(root.right, true, 1);
        } else {
            helper(root.right, true, currZigZag + 1);
            helper(root.left, false,  1);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        root.right.right.left.right = new TreeNode(7);
        root.right.right.left.right.right = new TreeNode(8);

        Assert.assertEquals(3, longestZigZag(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.left.right = new TreeNode(7);

        Assert.assertEquals(4, longestZigZag(root));
    }
}
