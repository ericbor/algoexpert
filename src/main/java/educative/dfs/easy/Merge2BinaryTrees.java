package educative.dfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//https://leetcode.com/problems/merge-two-binary-trees/
public class Merge2BinaryTrees {
    public TreeNode mergeTreesRec(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;
        root1.left = mergeTreesRec(root1.left, root2.left);
        root1.right = mergeTreesRec(root1.right, root2.right);

        return root1;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }

        Deque<TreeNode[]> stack = new ArrayDeque<>();
        stack.push(new TreeNode[] { root1, root2 });

        while (!stack.isEmpty()) {
            TreeNode[] curr = stack.pop();
            if (curr[0] == null || curr[1] == null) {
                continue;
            }

            curr[0].val += curr[1].val;

            if (curr[0].left == null) {
                curr[0].left = curr[1].left;
            } else {
                stack.push(new TreeNode[] { curr[0].left, curr[1].left });
            }

            if (curr[0].right == null) {
                curr[0].right = curr[1].right;
            } else {
                stack.push(new TreeNode[] { curr[0].right, curr[1].right });
            }
        }

        return root1;
    }

    @Test
    public void verify() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode result = mergeTrees(root1, root2);
        Assert.assertEquals(3, result.val);
        Assert.assertEquals(4, result.left.val);
        Assert.assertEquals(5, result.left.left.val);
        Assert.assertEquals(4, result.left.right.val);
        Assert.assertEquals(5, result.right.val);
        Assert.assertEquals(7, result.right.right.val);
    }

    @Test
    public void verify2() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        TreeNode result = mergeTreesRec(root1, root2);
        Assert.assertEquals(3, result.val);
        Assert.assertEquals(4, result.left.val);
        Assert.assertEquals(5, result.left.left.val);
        Assert.assertEquals(4, result.left.right.val);
        Assert.assertEquals(5, result.right.val);
        Assert.assertEquals(7, result.right.right.val);
    }
}
