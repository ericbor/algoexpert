package leetcode.tree;

import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
public class KthSmallestElementInBst {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            k--;
            if(k == 0) {
                return root.val;
            }

            root = root.right;
        }

        return -1;
    }
}
