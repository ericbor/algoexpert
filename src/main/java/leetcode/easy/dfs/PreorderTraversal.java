package leetcode.easy.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-preorder-traversal/solution/
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        helper(root, results);
        return results;
    }

    private void helper(TreeNode node, List<Integer> results) {
        if (node == null) {
            return;
        }

        results.add(node.val);
        helper(node.left, results);
        helper(node.right, results);
    }

    public List<Integer> preorderTraversalRec(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<Integer> results = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            results.add(curr.val);

            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return results;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        Assert.assertEquals(List.of(10, 5, 3, 7, 15, 18), preorderTraversal(root));
    }

    @Test
    public void testRec() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        Assert.assertEquals(List.of(10, 5, 3, 7, 15, 18), preorderTraversalRec(root));
    }
}
