package leetcode.tree;

import tree.design.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/description/
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int dfs(TreeNode node) {
        // An empty tree has height -1
        if (node == null) {
            return -1;
        }

        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }
}
