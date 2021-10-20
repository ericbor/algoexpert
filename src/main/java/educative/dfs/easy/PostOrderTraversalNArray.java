package educative.dfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//https://leetcode.com/problems/n-ary-tree-postorder-traversal/
public class PostOrderTraversalNArray {
    public List<Integer> postorder(Node root) {
        List<Integer> results = new ArrayList<>();
        results = helper(root, results);
        return results;
    }

    private List<Integer> helper(Node node, List<Integer> results) {
        if (node == null) {
            return results;
        }

        if (node.children != null) {
            for (Node child : node.children) {
                helper(child, results);
            }
        }
        results.add(node.val);

        return results;
    }

    public List<Integer> postorderIter(Node root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pollLast();

            results.add(0, curr.val);

            if (curr.children != null) {
                for (Node item : curr.children) {
                    if (item != null) {
                        stack.add(item);
                    }
                }
            }

        }

        return results;
    }

    @Test
    public void test() {
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        root.children = List.of(node1, node2, node3);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node1.children = List.of(node4, node5);

        Assert.assertEquals(List.of(5, 6, 3, 2, 4, 1), postorderIter(root));
    }

    @Test
    public void test2() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        root.children = List.of(node1, node2, node3, node4);

        Node node5 = new Node(6);
        Node node6 = new Node(7);
        node2.children = List.of(node5, node6);

        Node node7 = new Node(11);
        node6.children = List.of(node7);

        Node node8 = new Node(14);
        node7.children = List.of(node8);

        Node node9 = new Node(8);
        node3.children = List.of(node9);

        Node node10 = new Node(12);
        node9.children = List.of(node10);

        Node node11 = new Node(9);
        Node node12 = new Node(10);
        node4.children = List.of(node11, node12);

        Node node13 = new Node(13);
        node11.children = List.of(node13);

        Assert.assertEquals(List.of(2, 6, 14, 11, 7, 3, 12, 8, 4, 13, 9, 10, 5, 1), postorderIter(root));
    }

    @Test
    public void test3() {
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        root.children = List.of(node1, node2, node3);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node1.children = List.of(node4, node5);

        Assert.assertEquals(List.of(5, 6, 3, 2, 4, 1), postorder(root));
    }

    @Test
    public void test4() {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        root.children = List.of(node1, node2, node3, node4);

        Node node5 = new Node(6);
        Node node6 = new Node(7);
        node2.children = List.of(node5, node6);

        Node node7 = new Node(11);
        node6.children = List.of(node7);

        Node node8 = new Node(14);
        node7.children = List.of(node8);

        Node node9 = new Node(8);
        node3.children = List.of(node9);

        Node node10 = new Node(12);
        node9.children = List.of(node10);

        Node node11 = new Node(9);
        Node node12 = new Node(10);
        node4.children = List.of(node11, node12);

        Node node13 = new Node(13);
        node11.children = List.of(node13);

        Assert.assertEquals(List.of(2, 6, 14, 11, 7, 3, 12, 8, 4, 13, 9, 10, 5, 1), postorder(root));
    }
}
