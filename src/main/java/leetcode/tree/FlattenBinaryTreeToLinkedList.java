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
