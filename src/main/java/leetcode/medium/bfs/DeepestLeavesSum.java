package leetcode.medium.bfs;

import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/deepest-leaves-sum/
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int currSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                currSum += curr.val;

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            sum = currSum;

        }

        return sum;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
    }
}
