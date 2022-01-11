package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/diameter-of-binary-tree/
public class DiameterOfBinaryTree {
    private int diameter = 0;
    private List<Integer> maxPath = new ArrayList<>();

    public int diameterOfBinaryTree(TreeNode root) {
        List<TreeNode> path = new ArrayList<>();
        path.add(root);

        collectPaths(root, path);

        return diameter;
    }

    private List<Integer> collectPaths(TreeNode node, List<Integer> parentPath) {
        if (node == null) {
            return new ArrayList<>();
        }

        // add this node to the parent
        parentPath.add(node);

        // start a new path from this node
        List<Integer> path = new ArrayList<>();
        path.add(node.val);
        List<Integer> pathLeft = collectPaths(node.left, path);
        List<Integer> pathRight = collectPaths(node.right, path);

        if (pathLeft.size() + pathRight.size() > diameter) {
            List<Integer> newMaxPath = new ArrayList<>();
            newMaxPath.addAll(pathLeft);
            newMaxPath.add(node.val);
            newMaxPath.addAll(pathRight);
            maxPath = newMaxPath;

            diameter = pathLeft.size() + pathRight.size();
        }

        // pick one to go up to the parent
        if (pathLeft.size() > pathRight.size()) {
            pathLeft.add(node.val);
            return pathLeft;
        }

        pathRight.add(node.val);
        return pathRight;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        Assert.assertEquals(3, diameterOfBinaryTree(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        Assert.assertEquals(1, diameterOfBinaryTree(root));
    }
}
