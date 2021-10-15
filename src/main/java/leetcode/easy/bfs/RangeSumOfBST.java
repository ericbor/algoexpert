package leetcode.easy.bfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/range-sum-of-bst/
public class RangeSumOfBST {
    int sum;

    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int rangeSum = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.val >= low && curr.val <= high) {
                rangeSum += curr.val;
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        return rangeSum;
    }

    public int rangeSumBST3(TreeNode root, int low, int high) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (low <= curr.val && curr.val <= high) {
                sum += curr.val;
            }

            if (curr.left != null && curr.val > low) {
                stack.push(curr.left);
            }
            if (curr.right != null && curr.val < high) {
                stack.push(curr.right);
            }
        }
        return sum;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }

        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }

        if (low < node.val) {
            dfs(node.left, low, high);
        }
        if (node.val < high) {
            dfs(node.right, low, high);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        Assert.assertEquals(32, rangeSumBST3(root, 7, 15));
    }
}
