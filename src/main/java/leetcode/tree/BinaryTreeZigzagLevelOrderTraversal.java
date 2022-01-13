package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean startOrder = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                if (startOrder) {
                    levelValues.add(curr.val);
                } else {
                    levelValues.add(0, curr.val);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            startOrder = !startOrder;
            results.add(levelValues);
        }

        return results;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-1);
        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);

        Assert.assertEquals(List.of(List.of(0), List.of(4, 2), List.of(1, 3, -1), List.of(8, 6, 1, 5)), zigzagLevelOrder(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);

        Assert.assertEquals(List.of(List.of(1)), zigzagLevelOrder(root));
    }

    @Test
    public void test3() {

        Assert.assertEquals(Collections.emptyList(), zigzagLevelOrder(null));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(List.of(List.of(3), List.of(20, 9), List.of(15, 7)), zigzagLevelOrder(root));
    }

    @Test
    public void test5() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(11);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(List.of(List.of(3), List.of(20, 9), List.of(10, 11, 15, 7)), zigzagLevelOrder(root));
    }
}
