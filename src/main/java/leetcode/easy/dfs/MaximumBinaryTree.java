package leetcode.easy.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/maximum-binary-tree/
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return helper(nums, 0, nums.length);

    }

    private TreeNode helper(int[] arr, int start, int end) {
        if (start == end) {
            return null;
        }

        int maxIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(arr[maxIndex]);
        node.left = helper(arr, start, maxIndex);
        node.right = helper(arr, maxIndex + 1, end);

        return node;
    }

    public TreeNode constructMaximumBinaryTreeViaStuck(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        for (int num : nums) {
            TreeNode cur = new TreeNode(num);

            while (!stack.isEmpty() && stack.peek().val < num) {
                cur.left = stack.pop();
            }

            if (!stack.isEmpty()) {
                stack.peek().right = cur;
            }

            stack.push(cur);
        }
        return stack.peekLast();
    }

    @Test
    public void test() {
        TreeNode node = constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 });
        Assert.assertEquals(6, node.val);
        Assert.assertEquals(3, node.left.val);
        Assert.assertEquals(2, node.left.right.val);
        Assert.assertEquals(1, node.left.right.right.val);

        Assert.assertEquals(5, node.right.val);
        Assert.assertEquals(0, node.right.left.val);
    }

    @Test
    public void test2() {
        TreeNode node = constructMaximumBinaryTreeViaStuck(new int[] { 3, 2, 1, 6, 0, 5 });
        Assert.assertEquals(6, node.val);
        Assert.assertEquals(3, node.left.val);
        Assert.assertEquals(2, node.left.right.val);
        Assert.assertEquals(1, node.left.right.right.val);

        Assert.assertEquals(5, node.right.val);
        Assert.assertEquals(0, node.right.left.val);
    }
}
