package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class CountGoodNodesInBinaryTree {
    private int numGoodNodes;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }

    private void dfs(TreeNode node, int maxSoFar) {
        if (node.val >= maxSoFar) {
            numGoodNodes++;
        }

        if (node.right != null) {
            dfs(node.right, Math.max(node.val, maxSoFar));
        }

        if (node.left != null) {
            dfs(node.left, Math.max(node.val, maxSoFar));
        }
    }

    public int goodNodesBFS(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, Integer.MIN_VALUE));

        int counter = 0;
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode node = curr.node;
            if(node.val >= curr.maxSoFar) {
                counter++;
            }

            if(node.left != null) {
                queue.add(new Pair(node.left, Math.max(curr.maxSoFar, node.val)));
            }
            if(node.right != null) {
                queue.add(new Pair(node.right, Math.max(curr.maxSoFar, node.val)));
            }
        }

        return counter;
    }

    class Pair {
        TreeNode node;
        Integer maxSoFar;
        public Pair(TreeNode node, Integer maxSoFar) {
            this.node = node;
            this.maxSoFar = maxSoFar;
        }
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(1);

        Assert.assertEquals(4, goodNodes(root));
        Assert.assertEquals(4, goodNodesBFS(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);

        Assert.assertEquals(3, goodNodes(root));
        Assert.assertEquals(3, goodNodesBFS(root));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(1);

        Assert.assertEquals(1, goodNodes(root));
        Assert.assertEquals(1, goodNodesBFS(root));
    }
}
