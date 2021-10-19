package educative.dfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
public class InorderTraversalNArray {
    public List<Integer> preorder(Node root) {
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

    public List<Integer> preorderIter(Node root) {
        List<Integer> results = new ArrayList<>();
        if(root == null) {
            return results;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            results.add(curr.val);

            if(curr.children != null) {
                for(int i = curr.children.size() - 1; i >= 0; i--){
                    stack.push(curr.children.get(i));
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

        Assert.assertEquals(List.of(1,3,5,6,2,4), preorderIter(root));
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

        Assert.assertEquals(List.of(1,3,5,6,2,4), preorder(root));
    }
}
