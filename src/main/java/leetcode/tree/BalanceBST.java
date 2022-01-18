package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/balance-a-binary-search-tree/
public class BalanceBST {
    private final List<TreeNode> values = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);

        return constructBST(0, values.size() - 1);
    }

    private TreeNode constructBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;

        TreeNode root = values.get(mid);
        root.left = constructBST(start, mid - 1);
        root.right = constructBST(mid + 1, end);

        return root;
    }

    private void inorder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            values.add(root);
            root = root.right;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode bst = balanceBST(root);
        Assert.assertEquals(2, bst.val);
        Assert.assertEquals(1, bst.left.val);
        Assert.assertEquals(3, bst.right.val);
        Assert.assertEquals(4, bst.right.right.val);

        Assert.assertNull(bst.left.left);
        Assert.assertNull(bst.left.right);
        Assert.assertNull(bst.right.left);
        Assert.assertNull(bst.right.right.left);
        Assert.assertNull(bst.right.right.right);
    }
}
