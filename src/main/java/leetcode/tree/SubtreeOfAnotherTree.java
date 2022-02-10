package leetcode.tree;

import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<TreeNode> compareNodes = getCompareNodes(root, subRoot.val);
        if(compareNodes.isEmpty()) {
            return false;
        }

        for(TreeNode toCompare: compareNodes) {
            if(isSame(toCompare, subRoot)) {
                return true;
            }
        }

        return false;
    }

    private boolean isSame(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        if(t1.val != t2.val) {
            return false;
        }

        boolean isLeftSame = isSame(t1.left, t2.left);
        boolean isRightSame = isSame(t1.right, t2.right);

        return isLeftSame && isRightSame;
    }

    private List<TreeNode> getCompareNodes(TreeNode node, int target) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        List<TreeNode> nodes = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(curr.val == target) {
                    nodes.add(curr);
                }

                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        return nodes;
    }
}
