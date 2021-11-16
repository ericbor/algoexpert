package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        leftQueue.add(root.left);
        Queue<TreeNode> rightQueue = new LinkedList<>();
        rightQueue.add(root.right);

        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode currLeft = leftQueue.poll();
            TreeNode currRight = rightQueue.poll();

            if (currLeft == null && currRight == null) {
                continue;
            }
            if (currLeft == null || currRight == null) {
                return false;
            }
            if (currLeft.val != currRight.val) {
                return false;
            }

            leftQueue.add(currLeft.left);
            leftQueue.add(currLeft.right);

            rightQueue.add(currRight.right);
            rightQueue.add(currRight.left);
        }

        return true;
    }

    public boolean isSymmetricRec(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(-42);
        root.right = new TreeNode(-42);

        root.left.right = new TreeNode(76);
        root.right.left = new TreeNode(76);

        root.left.right.right = new TreeNode(13);
        root.right.left.right = new TreeNode(13);

        Assert.assertFalse(isSymmetricRec(root));
        Assert.assertFalse(isSymmetric(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        Assert.assertTrue(isSymmetricRec(root));
        Assert.assertTrue(isSymmetric(root));
    }
}
