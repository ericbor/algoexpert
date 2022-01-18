package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/boundary-of-binary-tree/
public class BoundaryOfBinaryTree {
    private final List<Integer> values = new ArrayList<>(1000);

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return values;
        }
        values.add(root.val);

        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return values;
    }

    private void leaves(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            values.add(node.val);
            return;
        }

        leaves(node.left);
        leaves(node.right);
    }

    private void leftBoundary(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }

        values.add(node.val);

        if (node.left == null) {
            leftBoundary(node.right);
        } else {
            leftBoundary(node.left);
        }
    }

    private void rightBoundary(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }

        if (node.right == null) {
            rightBoundary(node.left);
        } else {
            rightBoundary(node.right);
        }

        values.add(node.val); // add after child visit(reverse)
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);

        Assert.assertEquals(List.of(1, 2, 4, 7, 8, 9, 10, 6, 3), boundaryOfBinaryTree(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        Assert.assertEquals(List.of(1, 3, 4, 2), boundaryOfBinaryTree(root));
    }
}
