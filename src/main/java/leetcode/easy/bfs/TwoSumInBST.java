package leetcode.easy.bfs;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class TwoSumInBST {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                int diff = k - curr.val;
                if (set.contains(diff)) {
                    return true;
                }
                set.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        return false;
    }

    public boolean findTargetRec(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

        boolean left = find(root.left, k, set);
        boolean righ = find(root.right, k, set);
        return left || righ;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        Assert.assertTrue(findTarget(root, 9));
        Assert.assertTrue(findTargetRec(root, 9));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        Assert.assertTrue(findTarget(root, 11));
        Assert.assertTrue(findTargetRec(root, 11));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        Assert.assertFalse(findTarget(root, 28));
        Assert.assertFalse(findTargetRec(root, 28));
    }
}
