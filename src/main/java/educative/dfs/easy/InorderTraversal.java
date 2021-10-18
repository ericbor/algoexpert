package educative.dfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InorderTraversal {
    public List<Integer> inorderTraversalIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        List<Integer> results = new ArrayList<>();

        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            results.add(curr.val);
            curr = curr.right;
        }

        return results;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        helper(root, results);

        return results;
    }

    private void helper(TreeNode node, List<Integer> results) {
        if (node == null) {
            return;
        }

        helper(node.left, results);
        results.add(node.val);
        helper(node.right, results);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Assert.assertEquals(List.of(1, 3, 2), inorderTraversal(root));
        Assert.assertEquals(List.of(1, 3, 2), inorderTraversalIter(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        Assert.assertEquals(List.of(2, 1), inorderTraversal(root));
        Assert.assertEquals(List.of(2, 1), inorderTraversalIter(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        Assert.assertEquals(List.of(1, 2), inorderTraversal(root));
        Assert.assertEquals(List.of(1, 2), inorderTraversalIter(root));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Assert.assertEquals(List.of(4, 2, 5, 1, 6, 3), inorderTraversal(root));
        Assert.assertEquals(List.of(4, 2, 5, 1, 6, 3), inorderTraversalIter(root));
    }
}
