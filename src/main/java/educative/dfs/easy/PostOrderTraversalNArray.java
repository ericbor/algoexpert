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

    private List<Integer> helper(Node node, List<Integer> results){
        if(node == null) {
            return results;
        }

        results.add(node.val);

        if(node.children != null) {
            for(Node child: node.children) {
                helper(child, results);
            }
        }


        return results;
    }

    public List<Integer> postorderIter(Node root) {
        List<Integer> results = new ArrayList<>();
        if(root == null) {
            return results;
        }

        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pollLast();

            results.add(0, curr.val);

            if(curr.children != null) {
                for(Node node : curr.children){
                    if(node != null) {
                        stack.add(node);
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

        Assert.assertEquals(List.of(5,6,3,2,4,1), postorderIter(root));
    }

    @Test
    public void test2() {
        Node root = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        root.children = List.of(node1, node2, node3);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        node1.children = List.of(node4, node5);

        Assert.assertEquals(List.of(5,6,3,2,4,1), postorder(root));
    }
}
