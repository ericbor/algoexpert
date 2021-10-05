package educative.bfs.medium;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, populate an array to represent its zigzag level order traversal.
You should populate the values of all nodes of the first level FROM LEFT TO RIGHT, then RIGHT TO LEFT for the next level
and keep alternating in the same manner for the following levels.
 */
public class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new LinkedList<>();
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (leftToRight) {
                    currentLevel.add(currentNode.val);
                } else {
                    currentLevel.add(0, currentNode.val);
                }

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        Assert.assertEquals(List.of(List.of(12), List.of(1, 7), List.of(9, 10, 5), List.of(17, 20)), traverse(root));
    }
}
