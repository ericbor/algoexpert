package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Preorder {
    public List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> results = new ArrayList<>();

        preorder(root, results);
        return results;
    }

    private void preorder(TreeNode node, List<Integer> results) {
        if (node == null) {
            return;
        }

        results.add(node.val);
        preorder(node.left, results);
        preorder(node.right, results);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            values.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return values;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(List.of(1, 2, 4, 5, 3, 6, 7), preorderTraversal(root));
    }
}
