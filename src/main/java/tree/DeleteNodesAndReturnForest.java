package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//https://leetcode.com/problems/delete-nodes-and-return-forest
public class DeleteNodesAndReturnForest {
    private Set<Integer> dict;
    private final List<TreeNode> results = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        dict = Arrays.stream(toDelete).boxed().collect(Collectors.toSet());

        deleteNodes(root, null);
        return results;
    }

    private TreeNode deleteNodes(TreeNode root, TreeNode parent) {
        if (root == null) {
            return null;
        }

        TreeNode current = dict.contains(root.val) ? null : root;
        if (parent == null && current != null) {
            results.add(root);
        }
        root.left = deleteNodes(root.left, current);
        root.right = deleteNodes(root.right, current);

        return current;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<TreeNode> forest = delNodes(root, new int[]{3,5});
        TreeNode a = forest.get(0);
        Assert.assertEquals(1, a.val);
        Assert.assertEquals(2, a.left.val);
        Assert.assertEquals(4, a.left.left.val);
        Assert.assertNull(a.right);

        TreeNode b = forest.get(1);
        Assert.assertEquals(6, b.val);
        Assert.assertNull(b.right);
        Assert.assertNull(b.left);

        TreeNode c = forest.get(2);
        Assert.assertEquals(7, c.val);
        Assert.assertNull(c.right);
        Assert.assertNull(c.left);


    }
}
