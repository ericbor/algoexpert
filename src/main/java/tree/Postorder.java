package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Postorder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        helper(root, results);

        return results;
    }

    private void helper(TreeNode node, List<Integer> results) {
        if(node == null) {
            return;
        }

        helper(node.left, results);
        helper(node.right, results);
        results.add(node.val);
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

        Assert.assertEquals(List.of(4,5,2,6,7,3,1), postorderTraversal(root));
    }
}
