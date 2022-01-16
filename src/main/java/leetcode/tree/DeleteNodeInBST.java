package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/delete-node-in-a-bst/
public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode parent = null;

        // Binary search to find the node with value key.
        while (curr != null && curr.val != key) {
            parent = curr;
            if (key < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        // We didn't find the given key in the given tree.
        if (curr == null) {
            return root;
        }

        //node to delete is root one
        if (parent == null) {
            return deleteRootNode(curr);
        }

        if (parent.left == curr) {
            parent.left = deleteRootNode(curr);
        } else {
            parent.right = deleteRootNode(curr);
        }

        return root;
    }

    private TreeNode deleteRootNode(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }

        // Find the smallest node in the right subtree of the given root node (cause right is bigger than left - need to append left node (smaller) to right one (bigger) )
        TreeNode next = findMin(root.right);
        // Replace the root with the replacement.
        next.left = root.left;

        return root.right;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode updated = deleteNode(root, 3);

        Assert.assertEquals(5, updated.val);
        Assert.assertEquals(4, updated.left.val);
        Assert.assertEquals(2, updated.left.left.val);
        Assert.assertNull(updated.left.right);
        Assert.assertNull(updated.left.left.left);
        Assert.assertNull(updated.left.left.right);
        Assert.assertEquals(6, updated.right.val);
        Assert.assertEquals(7, updated.right.right.val);
        Assert.assertNull(updated.right.left);
        Assert.assertNull(updated.right.right.right);
        Assert.assertNull(updated.right.right.left);
    }

    @Test
    public void testDeleteRoot() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        TreeNode updated = deleteNode(root, 5);

        Assert.assertEquals(6, updated.val);
        Assert.assertEquals(7, updated.right.val);
        Assert.assertNull(updated.right.left);
        Assert.assertNull(updated.right.right);
        Assert.assertEquals(3, updated.left.val);
        Assert.assertEquals(2, updated.left.left.val);
        Assert.assertEquals(4, updated.left.right.val);
        Assert.assertNull(updated.left.left.left);
        Assert.assertNull(updated.left.left.right);
        Assert.assertNull(updated.left.right.left);
        Assert.assertNull(updated.left.right.right);
    }
}
