package leetcode.easy.bfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/minimum-distance-between-bst-nodes/
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        Queue<Integer> values = new PriorityQueue<>();
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            values.add(curr.val);

            if (curr.left != null) {
                stack.add(curr.left);
            }

            if (curr.right != null) {
                stack.add(curr.right);
            }
        }

        int minDiff = Integer.MAX_VALUE;
        while (values.size() > 1) {
            int first = values.poll();
            int second = values.peek();

            minDiff = Math.min(minDiff, second - first);
        }

        return minDiff;
    }

    private Integer prev = null;
    private Integer ans = Integer.MAX_VALUE;
    //INORDER traversal gives BST values in sorted order
    public int minDiffInBST(TreeNode root) {
        dfs(root);

        return ans;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        if (prev != null) {
            ans = Math.min(ans, node.val - prev);
        }
        prev = node.val;
        dfs(node.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(90);
        root.left = new TreeNode(69);
        root.left.left = new TreeNode(49);
        root.left.right = new TreeNode(89);
        root.left.left.right = new TreeNode(52);

        Assert.assertEquals(1, minDiffInBST(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Assert.assertEquals(1, minDiffInBST(root));
    }
}
