package educative.bfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && val != root.val) {
            if(val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return root;
    }

    public TreeNode searchBSTrec(TreeNode root, int val) {
        if(root == null || root.val == val) {
            return root;
        }

        if(root.val > val) {
            root = searchBST(root.left, val);
        } else {
            root = searchBST(root.right, val);
        }

        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = searchBST(root, 2);
        Assert.assertEquals(2, result.val);
        Assert.assertEquals(1, result.left.val);
        Assert.assertEquals(3, result.right.val);

    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = searchBSTrec(root, 2);
        Assert.assertEquals(2, result.val);
        Assert.assertEquals(1, result.left.val);
        Assert.assertEquals(3, result.right.val);

    }
}
