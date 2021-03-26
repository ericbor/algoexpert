package tree.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepth {
    //DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return Math.max(leftHeight, rightHeight) + 1;//including root
    }

    public int maxDepthIterative(TreeNode root) {
        if(root == null) {
            return 0;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();

        stack.add(root);
        depths.add(1);

        int depth = 0;
        int currentDepth = 0;
        while(!stack.isEmpty()){
            root = stack.pollLast();
            currentDepth = depths.pollLast();
            if(root != null) {
                depth = Math.max(depth, currentDepth);

                stack.add(root.left);
                stack.add(root.right);

                depths.add(currentDepth + 1);
                depths.add(currentDepth + 1);
            }
        }

        return depth;
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

        Assert.assertEquals(4, maxDepth(root));
        Assert.assertEquals(4, maxDepthIterative(root));
    }
}
