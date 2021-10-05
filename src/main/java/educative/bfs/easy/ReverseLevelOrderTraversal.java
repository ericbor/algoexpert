package educative.bfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.educative.io/courses/grokking-the-coding-interview/m2N6GwARL8r
/*
Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, i.e., the lowest level comes first.
You should populate the values of all nodes in each level from left to right in separate sub-arrays.
 */
public class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelsSize = queue.size();
            for (int i = 0; i < levelsSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            levels.add(0, currentLevel);
        }

        return levels;
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        Assert.assertEquals(List.of(List.of(9, 10, 5), List.of(7, 1), List.of(12)), traverse(root));
    }
}
