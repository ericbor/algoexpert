package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> maxRootPath = new HashMap<>(); //cache
        maxRootPath.put(null, 0); //to handle null nodes for simplicity

        Iterable<TreeNode> postOrder = sort(root);

        int result = Integer.MIN_VALUE;
        for(TreeNode node: postOrder) {
            // as we process nodes in post-order their children are already cached
            int left = Math.max(maxRootPath.get(node.left), 0);
            int right = Math.max(maxRootPath.get(node.right), 0);
            int childrenMax = Math.max(left, right);
            int pathSum = node.val + childrenMax;
            maxRootPath.put(node, pathSum);

            result = Math.max(result, left + right + node.val);
        }

        return result;
    }

    private Iterable<TreeNode> sort(TreeNode root) {
        Deque<TreeNode> results = new ArrayDeque<>();

        if(root != null) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                results.push(curr);

                if(curr.left != null) {
                    stack.push(curr.left);
                }
                if(curr.right != null) {
                    stack.push(curr.right);
                }

            }
        }

        return results;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Assert.assertEquals(6, maxPathSum(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(42, maxPathSum(root));
    }
}
