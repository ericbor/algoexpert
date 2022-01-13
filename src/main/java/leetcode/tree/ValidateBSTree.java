package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/validate-binary-search-tree/
public class ValidateBSTree {

    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && root.val <= prev.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }

        return true;
    }

    public List<Integer> inorderIterativeSort(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        //TreeNode prev = null;

        List<Integer> values = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            values.add(root.val);

            //prev = root;
            root = root.right;
        }

        return values;
    }

    private final List<Integer> values = new ArrayList<>();

    public boolean isValidBST_dfs(TreeNode root) {
        inorder(root);

        return isSorted();
    }

    private boolean isSorted() {
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i - 1) >= values.get(i)) {
                return false;
            }
        }

        return true;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        Assert.assertFalse(isValidBST(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        Assert.assertTrue(isValidBST(root));
    }
}
