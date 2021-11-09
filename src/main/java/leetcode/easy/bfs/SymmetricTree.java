package leetcode.easy.bfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/symmetric-tree/
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

    @Test
    public void test() {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(-42);
        root.right = new TreeNode(-42);

        root.left.right = new TreeNode(76);
        root.right.left = new TreeNode(76);

        root.left.right.right = new TreeNode(13);
        root.right.left.right = new TreeNode(13);

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
        Assert.assertTrue(isSymmetric(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        Assert.assertFalse(isSymmetric(root));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(1);
        Assert.assertTrue(isSymmetric(root));
    }
}
