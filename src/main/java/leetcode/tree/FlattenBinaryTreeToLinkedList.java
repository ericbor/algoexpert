package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode curr = root;

        while (curr != null) {
            //If the node has a left child
            if (curr.left != null) {
                //Find the rightmost node
                TreeNode rightmost = curr.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                //rewiere the connections
                rightmost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            // move on to the right side of the tree
            curr = curr.right;
        }
    }

    public void flatten2(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node) {

        // Handle the null scenario
        if (node == null) {
            return null;
        }

        // For a leaf node, we simply return the node as is.
        if (node.left == null && node.right == null) {
            return node;
        }

        //Recursively flatten the left subtree
        TreeNode leftTail = flattenTree(node.left);

        // Recursively flatten the right subtree
        TreeNode rightTail = flattenTree(node.right);

        // If there was a left subtree, we shuffle the connections around so that there is nothing on the left side anymore.
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        // We need to return the "rightmost" node after we are done wiring the new connections.
        return rightTail == null ? leftTail : rightTail;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        flatten(root);

        Assert.assertEquals(1, root.val);
        Assert.assertEquals(2, root.right.val);
        Assert.assertEquals(3, root.right.right.val);
        Assert.assertEquals(4, root.right.right.right.val);
        Assert.assertEquals(5, root.right.right.right.right.val);
        Assert.assertEquals(6, root.right.right.right.right.right.val);
        Assert.assertNull(root.left);
    }
}
