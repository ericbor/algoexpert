package tree.medium;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
//Breadth First Search
public class LevelOrderTraversal {
    private final List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }

        helper(root, 0);

        return levels;
    }

    private void helper(TreeNode node, int level) {
        //start the current level
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        //fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }
    }

    public List<List<Integer>> levelOrder_Iterative(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        TreeNode current;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {// traverse nodes in the same level
                current = queue.pollFirst();
                level.add(current.val);// visit the root

                if (current.left != null) {
                    queue.add(current.left);// push left child to queue if it is not null
                }
                if (current.right != null) {
                    queue.add(current.right);// push right child to queue if it is not null
                }
            }

            levels.add(level);
        }

        return levels;
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(root);
        Assert.assertEquals(Arrays.asList(3), result.get(0));
        Assert.assertEquals(Arrays.asList(9, 20), result.get(1));
        Assert.assertEquals(Arrays.asList(15, 7), result.get(2));

        List<List<Integer>> resultIt = levelOrder_Iterative(root);
        Assert.assertEquals(Arrays.asList(3), resultIt.get(0));
        Assert.assertEquals(Arrays.asList(9, 20), resultIt.get(1));
        Assert.assertEquals(Arrays.asList(15, 7), resultIt.get(2));
    }
}
