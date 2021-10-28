package leetcode.easy.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
public class SumOfRootToLeafBinaryNumbers {
    int rootToLeafSum = 0;

    public int sumRootToLeaf(TreeNode root) {
        preorder(root, "");
        return rootToLeafSum;
    }

    private void preorder(TreeNode node, String currNum) {
        if(node == null) {
            return;
        }

        currNum += node.val;
        // if it's a leaf, update root-to-leaf sum
        if(node.left == null && node.right == null) {
            rootToLeafSum += Integer.parseInt(currNum, 2);
        }

        preorder(node.left, currNum);
        preorder(node.right, currNum);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        Assert.assertEquals(22, sumRootToLeaf(root));
    }
}
