package leetcode.easy.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/closest-binary-search-tree-value/
public class ClosestBSTValue {
    int result;
    public int closestValue(TreeNode root, double target) {

        double min = Integer.MAX_VALUE;
        preorder(root, min, target);

        return result;
    }

    private void preorder(TreeNode node, double min, double target) {
        if(node == null) {
            return;
        }

        double currDiff = Math.abs(node.val - target);
        if(currDiff < min) {
            min = currDiff;
            result = node.val;
        }

        min = Math.min(min, Math.abs(node.val - target));
        preorder(node.left, min, target);
        preorder(node.right, min, target);
    }

    public int closestValueBinSearch(TreeNode root, double target) {

        int val;
        int closest = root.val;

        while (root != null) {
            val = root.val;
            closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;

            root = target < root.val ? root.left : root.right;
        }

        return closest;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Assert.assertEquals(4, closestValue(root, 3.714286));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Assert.assertEquals(4, closestValueBinSearch(root, 3.714286));
    }
}
