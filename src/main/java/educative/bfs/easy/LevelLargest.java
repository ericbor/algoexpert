package educative.bfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://www.educative.io/courses/grokking-the-coding-interview/YQWkA2l67GW
 */
public class LevelLargest {
    public static List<Integer> findLevelLargest(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int largest = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                largest = Math.max(largest, currentNode.val);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(largest);
        }

        return result;
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        Assert.assertEquals(List.of(12, 7, 10), findLevelLargest(root));
    }
}
