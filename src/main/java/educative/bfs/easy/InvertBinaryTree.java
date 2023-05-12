package educative.bfs.easy;

import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        return new TreeNode(root.val, invertTree2(root.right), invertTree2(root.left));
    }
}
