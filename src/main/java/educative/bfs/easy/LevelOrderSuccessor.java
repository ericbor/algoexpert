package educative.bfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://www.educative.io/courses/grokking-the-coding-interview/7nO4VmA74Lr
public class LevelOrderSuccessor {
    public static TreeNode findSuccessor(TreeNode root, int key) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }

            if (curr.val == key) {
               break;
            }

        }
        return queue.peek();
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        TreeNode result = findSuccessor(root, 12);
        Assert.assertEquals(7, result.val);

        TreeNode result2 = findSuccessor(root, 9);
        Assert.assertEquals(10, result2.val);
    }
}
