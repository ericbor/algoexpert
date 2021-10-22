package educative.dfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/increasing-order-search-tree/
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);

        TreeNode result = new TreeNode(0);
        TreeNode curr = result;
        for(int val : values) {
            curr.right = new TreeNode(val);
            curr = curr.right;
        }

        return result.right;
    }

    private void inorder(TreeNode node, List<Integer> vals) {
        if(node == null) {
            return;
        }

        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode result = increasingBST(root);
        Assert.assertNull(result.left);
        Assert.assertEquals(1, result.val);
        Assert.assertEquals(2, result.right.val);
        Assert.assertEquals(3, result.right.right.val);
        Assert.assertEquals(4, result.right.right.right.val);
        Assert.assertEquals(5, result.right.right.right.right.val);
        Assert.assertEquals(6, result.right.right.right.right.right.val);
        Assert.assertEquals(7, result.right.right.right.right.right.right.val);
        Assert.assertEquals(8, result.right.right.right.right.right.right.right.val);
        Assert.assertEquals(9, result.right.right.right.right.right.right.right.right.val);
    }
}
