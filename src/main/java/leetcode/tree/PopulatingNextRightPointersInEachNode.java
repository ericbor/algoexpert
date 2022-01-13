package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

                if (i == levelSize - 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
            }
        }

        return root;
    }

    @Test
    public void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node connected = connect(root);
        Assert.assertNull(connected.next);
        Assert.assertEquals(3, connected.left.next.val);
        Assert.assertNull(connected.right.next);
        Assert.assertEquals(5, connected.left.left.next.val);
        Assert.assertEquals(6, connected.left.right.next.val);
        Assert.assertEquals(7, connected.right.left.next.val);
        Assert.assertNull(connected.right.right.next);
    }

    class Node {
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
            next = null;
        }
    }
}
