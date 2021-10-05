package educative.bfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://www.educative.io/courses/grokking-the-coding-interview/xV7E64m4lnz
public class LevelOrderTraversalRec {
    private final List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> traverse(TreeNode root) {

        if (root == null) {
            return levels;
        }

        helper(root, 0);

        return levels;
    }

    private void helper(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.val);

        if (node.left != null) {
            helper(node.left, level + 1);
        }
        if (node.right != null) {
            helper(node.right, level + 1);
        }

    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        Assert.assertEquals(List.of(List.of(12), List.of(7, 1), List.of(9, 10, 5)), traverse(root));
    }
}
