package educative.bfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.educative.io/courses/grokking-the-coding-interview/xV7E64m4lnz
public class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> levels = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // number of elements in the current level
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.remove();
                // fulfillthe current level
                currentLevel.add(currentNode.val);

                // add child nodes of the current level in the queue for the next level
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            levels.add(currentLevel);
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
        Assert.assertEquals(List.of(List.of(12), List.of(7, 1), List.of(9, 10, 5)), traverse(root));
    }
}
