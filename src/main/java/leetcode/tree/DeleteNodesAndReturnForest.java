package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/delete-nodes-and-return-forest/
public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        forest.add(root);

        Set<Integer> toDelete = new HashSet<>();
        for (int num : to_delete) {
            toDelete.add(num);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (toDelete.contains(curr.val)) {
                forest.remove(curr);
                if (curr.left != null) {
                    forest.add(curr.left);
                }
                if (curr.right != null) {
                    forest.add(curr.right);
                }
            }

            if (curr.left != null) {
                queue.add(curr.left);
                if (toDelete.contains(curr.left.val)) {
                    curr.left = null;
                }
            }

            if (curr.right != null) {
                queue.add(curr.right);
                if (toDelete.contains(curr.right.val)) {
                    curr.right = null;
                }
            }
        }

        return forest;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);

        List<TreeNode> forest = delNodes(root, new int[] { 2, 3 });
        Assert.assertEquals(2, forest.size());
        TreeNode node2 = forest.get(0);
        Assert.assertEquals(1, node2.val);
        Assert.assertNull(node2.right);
        Assert.assertNull(node2.left);

        TreeNode node3 = forest.get(1);
        Assert.assertEquals(4, node3.val);
        Assert.assertNull(node3.right);
        Assert.assertNull(node3.left);
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<TreeNode> forest = delNodes(root, new int[] { 3, 5 });
        TreeNode node1 = forest.get(0);
        Assert.assertEquals(1, node1.val);
        Assert.assertEquals(2, node1.left.val);
        Assert.assertEquals(4, node1.left.left.val);
        Assert.assertNull(node1.left.left.left);
        Assert.assertNull(node1.left.left.right);
        Assert.assertNull(node1.left.right);
        Assert.assertNull(node1.right);

        TreeNode node2 = forest.get(1);
        Assert.assertEquals(6, node2.val);
        Assert.assertNull(node2.right);
        Assert.assertNull(node2.left);

        TreeNode node3 = forest.get(2);
        Assert.assertEquals(7, node3.val);
        Assert.assertNull(node3.right);
        Assert.assertNull(node3.left);
    }
}
