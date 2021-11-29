package tree.topdown;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

public class PathSum {
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }

        boolean leftCheck = hasPathSum(root.left, sum);
        boolean rightCheck = hasPathSum(root.right, sum);

        return leftCheck || rightCheck;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode node, int targetSum, int currentSum) {
        if(node == null) {
            return false;
        }

        currentSum += node.val;

        if(node.left == null && node.right == null) {
                return currentSum == targetSum;
        }

        boolean inLeft = dfs(node.left, targetSum, currentSum);
        boolean inRight = dfs(node.right, targetSum, currentSum);

        return inLeft || inRight;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        Assert.assertTrue(hasPathSum(root, 22));
    }


    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        Assert.assertFalse(hasPathSum(root, 1));
    }
}
