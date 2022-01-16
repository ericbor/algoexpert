package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/recover-binary-search-tree/
public class RecoverBST {
    public void recoverTree_DFS(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        int[] swapped = findTwoSwapped(nums);

        recover(root, 2, swapped[0], swapped[1]);
    }

    private void recover(TreeNode node, int count, int x, int y) {
        if (node == null) {
            return;
        }

        if (node.val == x || node.val == y) {
            node.val = node.val == x ? y : x;
            count--;
            if (count == 0) {
                return;
            }
        }

        recover(node.left, count, x, y);
        recover(node.right, count, x, y);
    }

    private int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1;
        int y = -1;

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);

                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }

        return new int[] { x, y };
    }

    private void inorder(TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }

        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
    }

    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }

            pred = root;
            root = root.right;
        }

        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        recoverTree(root);

        Assert.assertEquals(2, root.val);
        Assert.assertEquals(1, root.left.val);
        Assert.assertEquals(4, root.right.val);
        Assert.assertEquals(3, root.right.left.val);
    }
}
