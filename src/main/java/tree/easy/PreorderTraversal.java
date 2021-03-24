package tree.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-preorder-traversal/
//Depth First Search
public class PreorderTraversal {

    /*
     *  ROOT-LEFT-RIGHT: B-A-C
     *
     *       B
     *      / \
     *     /   \
     *    A     C
     *
     * */

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return output;
    }

    public List<Integer> preorderTraversal_Recursive(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        helper(root, output);

        return output;
    }

    private void helper(TreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }
        output.add(root.val);
        helper(root.left, output);
        helper(root.right, output);
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        List<Integer> result = preorderTraversal(root);
        List<Integer> resultRec = preorderTraversal_Recursive(root);
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), result);
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), resultRec);
    }
}
