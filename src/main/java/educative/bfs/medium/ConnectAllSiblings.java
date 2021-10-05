package educative.bfs.medium;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://www.educative.io/courses/grokking-the-coding-interview/NE5109Jl02v
public class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            //TreeNode prev = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                /*if (prev != null) {
                    prev.next = curr;
                }*/
                //prev = curr;

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }

                if (!queue.isEmpty()) {
                    curr.next = queue.peek();
                }
            }
        }
    }

    public static void connect2(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode prev = null;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (prev != null) {
                prev.next = curr;
            }
            prev = curr;

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
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

        connect2(root);
        root.printLevelOrder();
        Assert.assertEquals(7, root.next.val);
        Assert.assertEquals(1, root.left.next.val);
        Assert.assertEquals(9, root.right.next.val);
        Assert.assertEquals(10, root.left.left.next.val);
        Assert.assertEquals(5, root.right.left.next.val);
        Assert.assertNull(root.right.right.next);
    }
}
