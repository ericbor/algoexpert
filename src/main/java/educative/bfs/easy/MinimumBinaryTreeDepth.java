package educative.bfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import javax.swing.tree.TreeModel;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumBinaryTreeDepth {
    public static int findDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int minimumTreeDepth = 0;

        while (!queue.isEmpty()) {
            minimumTreeDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                // check if this is a leaf node
                if (curr.left == null && curr.right == null) {
                    return minimumTreeDepth;
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return minimumTreeDepth;
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        Assert.assertEquals(2, findDepth(root));

        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        Assert.assertEquals(3, findDepth(root));
    }
}
