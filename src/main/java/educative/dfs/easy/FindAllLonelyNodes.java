package educative.dfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/find-all-the-lonely-nodes/
public class FindAllLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> results = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                queue.add(curr.left);
                if (curr.right == null) {
                    results.add(curr.left.val);
                }
            }
            if (curr.right != null) {
                queue.add(curr.right);
                if (curr.left == null) {
                    results.add(curr.right.val);
                }
            }
        }

        return results;
    }

    public List<Integer> getLonelyNodesRec(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root != null) {
            helper(root.left, root, results);
            helper(root.right, root, results);
        }
        return results;
    }

    private void helper(TreeNode node, TreeNode parent, List<Integer> results) {
        if (node == null) {
            return;
        }
        if (parent.left == null || parent.right == null) {
            results.add(node.val);
        }
        helper(node.left, node, results);
        helper(node.right, node, results);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(2);

        Assert.assertEquals(List.of(6, 2), getLonelyNodes(root));
        Assert.assertEquals(List.of(6, 2), getLonelyNodesRec(root));
    }
}
