package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class ConstructBSTFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);

            if (preorder[i] < stack.peek().val) {
                stack.peek().left = node;
            } else {
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }

            stack.push(node);
        }

        return root;
    }

    @Test
    public void test() {
        TreeNode root = bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });
        Assert.assertEquals(8, root.val);
        Assert.assertEquals(5, root.left.val);
        Assert.assertEquals(1, root.left.left.val);
        Assert.assertEquals(7, root.left.right.val);
        Assert.assertEquals(10, root.right.val);
        Assert.assertEquals(12, root.right.right.val);
        Assert.assertNull(root.right.left);
        Assert.assertNull(root.right.right.left);
        Assert.assertNull(root.right.right.right);
        Assert.assertNull(root.left.left.left);
        Assert.assertNull(root.left.left.right);
        Assert.assertNull(root.left.right.left);
        Assert.assertNull(root.left.right.right);
    }
}
