package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/trim-a-binary-search-tree/
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        //Find a valid root which is used to return.
        while (root.val < low || root.val > high) {
            if (root.val < low) {
                root = root.right;
            }
            if (root.val > high) {
                root = root.left;
            }
        }
        TreeNode curr = root;
        // Remove the invalid nodes from left subtree.
        while (curr != null) {
            while (curr.left != null && curr.left.val < low) {
                // If the left child is smaller than Low, then we just keep the right subtree of it.
                curr.left = curr.left.right;
            }
            curr = curr.left;
        }

        curr = root;
        // Remove the invalid nodes from right subtree
        while (curr != null) {
            while (curr.right != null && curr.right.val > high) {
                // If the right child is biggrt than R, then we just keep the left subtree of it.
                curr.right = curr.right.left;
            }
            curr = curr.right;
        }

        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(4);

        TreeNode trimmed = trimBST(root, 1, 3);
        Assert.assertEquals(3, trimmed.val);
        Assert.assertEquals(2, trimmed.left.val);
        Assert.assertEquals(1, trimmed.left.left.val);
        Assert.assertNull(trimmed.right);
        Assert.assertNull(trimmed.left.right);
        Assert.assertNull(trimmed.left.left.right);
        Assert.assertNull(trimmed.left.left.left);
    }
}
