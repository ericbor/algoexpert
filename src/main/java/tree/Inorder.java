package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Inorder {
    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);

        return values;
    }

    private void inorder(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inorder(node.left, values);
        values.add(node.val);
        inorder(node.right, values);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                values.add(curr.val);
                curr = curr.right;
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

        Assert.assertEquals(List.of(4, 2, 5, 1, 6, 3, 7), inorderTraversal(root));
    }
}
