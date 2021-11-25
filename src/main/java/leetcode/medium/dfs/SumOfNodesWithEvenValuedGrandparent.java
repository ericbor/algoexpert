package leetcode.medium.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
public class SumOfNodesWithEvenValuedGrandparent {
    private int sum;

    public int sumEvenGrandparent(TreeNode root) {
        helper(root, null, null);

        return sum;
    }

    private void helper(TreeNode curr, TreeNode parent, TreeNode grandparent) {
        if (curr == null) {
            return;
        }

        if (grandparent != null) {
            if (grandparent.val % 2 == 0) {
                sum += curr.val;
            }
        }
        grandparent = parent;
        parent = curr;

        helper(curr.left, parent, grandparent);
        helper(curr.right, parent, grandparent);

    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(5);

        Assert.assertEquals(18, sumEvenGrandparent(root));
    }
}
