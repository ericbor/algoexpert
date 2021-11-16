package leetcode.medium.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
public class GreaterSumTreeBST {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        //The right subtree of a node contains only nodes with keys greater than the node's key.
        bstToGst(root.right);
        sum += root.val;//update sum value
        root.val = sum;//update root val
        bstToGst(root.left);

        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        TreeNode result = bstToGst(root);
        Assert.assertEquals(30, root.val);
        Assert.assertEquals(36, root.left.val);
        Assert.assertEquals(36, root.left.left.val);
        Assert.assertEquals(35, root.left.right.val);
        Assert.assertEquals(33, root.left.right.right.val);
        Assert.assertEquals(21, root.right.val);
        Assert.assertEquals(26, root.right.left.val);
        Assert.assertEquals(15, root.right.right.val);
        Assert.assertEquals(8, root.right.right.right.val);
    }
}
