package educative.dfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://www.educative.io/courses/grokking-the-coding-interview/RMlGwgpoKKY
public class TreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        // if the current node is a leaf and its value is equal to the sum, we've found a path
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recursive call return true
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        Assert.assertTrue(hasPath(root, 23));
        Assert.assertFalse(hasPath(root, 16));
    }
}
