package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.Node;

import java.util.*;

//https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree
public class SerializeAndDeserializeNArrayTree {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);

        return sb.toString();
    }

    public void serializeHelper(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val);
        if (root.children != null && !root.children.isEmpty()) {
            sb.append(" [");
            for (Node child : root.children) {
                serializeHelper(child, sb.append(" "));
            }
            sb.append(" ]");
        }
    }

    public Node deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(" ");
        Deque<Node> stack = new ArrayDeque<>();
        Node curr = new Node(Integer.parseInt(nodes[0]), new LinkedList<>());
        Node parent = curr;

        for (int i = 1; i < nodes.length; i++) {
            if ("[".equals(nodes[i])) {
                stack.push(curr);
            } else if ("]".equals(nodes[i])) {
                stack.pop();
            } else {
                curr = new Node(Integer.parseInt(nodes[i]), new LinkedList<>());
                stack.peek().children.add(curr);
            }
        }
        return parent;
    }

    @Test
    public void test() {
        Node root = new Node(1);
        Node node = new Node(3, List.of(new Node(5), new Node(6)));
        root.children = List.of(node, new Node(2), new Node(4));

        String data = serialize(root);
        Node deserializedTree = deserialize(data);

        Assert.assertEquals(1, deserializedTree.val);
        Assert.assertEquals(3, deserializedTree.children.size());
        List<Node> children = deserializedTree.children;
        Assert.assertEquals(3, children.get(0).val);
        Assert.assertEquals(2, children.get(1).val);
        Assert.assertEquals(4, children.get(2).val);
        Assert.assertEquals(2, children.get(0).children.size());
        Assert.assertTrue(children.get(1).children.isEmpty());
        Assert.assertTrue(children.get(2).children.isEmpty());

        Assert.assertEquals(2, children.get(0).children.size());
        List<Node> children2 = children.get(0).children;
        Assert.assertEquals(5, children2.get(0).val);
        Assert.assertEquals(6, children2.get(1).val);
        Assert.assertTrue(children2.get(0).children.isEmpty());
        Assert.assertTrue(children2.get(1).children.isEmpty());

    }
}
