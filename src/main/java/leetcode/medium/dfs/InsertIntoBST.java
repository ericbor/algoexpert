package leetcode.medium.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/insert-into-a-binary-search-tree/
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        TreeNode result = insertIntoBST(root, 5);
        Assert.assertEquals(result.val, 4);
        Assert.assertEquals(result.left.val, 2);
        Assert.assertEquals(result.left.left.val, 1);
        Assert.assertEquals(result.left.right.val, 3);
        Assert.assertEquals(result.right.val, 7);
        Assert.assertEquals(result.right.left.val, 5);
    }
}
