package tree.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if(t1.val != t2.val) {
            return false;
        }

        return isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }

            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }

        return true;
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Assert.assertTrue(isSymmetric(root));
        Assert.assertTrue(isSymmetricRecursive(root));
    }
}
