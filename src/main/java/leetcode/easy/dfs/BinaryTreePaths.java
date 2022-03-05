package leetcode.easy.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-paths/
public class BinaryTreePaths {

    private final List<String> paths = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        helper(root, "");
        return paths;
    }

    public void helper(TreeNode root, String path) {
        if (root == null) {
            return;
        }

        path += root.val;
        if (root.left == null && root.right == null) {  // if reach a leaf
            paths.add(path);  // update paths
        } else {
            path += "->";  // extend the current path
            helper(root.left, path);
            helper(root.right, path);
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);

        Assert.assertEquals(List.of("1->2->5", "1->2->6", "1->3"), binaryTreePaths(root));
    }
}
