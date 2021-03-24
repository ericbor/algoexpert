package tree.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-inorder-traversal/
//Depth First Search
public class InorderTraversal {
    /*
     *  LEFT-ROOT-RIGHT: A-B-C
     *
     *       B
     *      / \
     *     /   \
     *    A     C
     *
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            current = stack.pollLast();
            output.add(current.val);
            current = current.right;
        }

        return output;
    }

    public List<Integer> inorderTraversal_Recursive(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        helper(root, output);

        return output;
    }

    private void helper(TreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }
        helper(root.left, output);
        output.add(root.val);
        helper(root.right, output);
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        List<Integer> result = inorderTraversal(root);
        List<Integer> result_rec = inorderTraversal_Recursive(root);
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 6, 3), result);
        Assert.assertEquals(Arrays.asList(4, 2, 5, 1, 6, 3), result_rec);
    }
}
