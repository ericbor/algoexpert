package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/maximum-width-of-binary-tree/
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);

        int currWidth = 0;
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int start = 0;
            int end = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                if (start == 0) {
                    start = map.get(curr);
                }
                if (i == levelSize - 1) {
                    end = map.get(curr);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                    map.put(curr.left, map.get(curr) * 2);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    map.put(curr.right, map.get(curr) * 2 + 1);
                }
            }

            currWidth = end - start + 1;
            maxWidth = Math.max(maxWidth, currWidth);
        }

        return maxWidth;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        Assert.assertEquals(4, widthOfBinaryTree(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(2);

        Assert.assertEquals(2, widthOfBinaryTree(root));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right = new TreeNode(2);

        Assert.assertEquals(2, widthOfBinaryTree(root));
    }
}
