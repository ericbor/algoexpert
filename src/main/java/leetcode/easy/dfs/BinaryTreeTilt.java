package leetcode.easy.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/binary-tree-tilt/
public class BinaryTreeTilt {
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        valueSum(root);

        return totalTilt;
    }

    protected int valueSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = valueSum(node.left);
        int rightSum = valueSum(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;

        // return the sum of values starting from this node.
        return node.val + leftSum + rightSum;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(15, findTilt(root));
    }
}
