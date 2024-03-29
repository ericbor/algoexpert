package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize_2(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();//LinkedList can handle nulls, ArrayDeque - can not
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("n").append(",");
            } else {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize_2(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (!"n".equals(values[i])) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            i++;
            if (!"n".equals(values[i])) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
            i++;
        }

        return root;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
        } else {
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q);
    }

    private TreeNode deserialize(Queue<String> q) {
        String s = q.poll();
        if ("#".equals(s)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String data = serialize_2(root);
        TreeNode deserializedTree = deserialize_2(data);

        Assert.assertEquals(1, deserializedTree.val);
        Assert.assertEquals(2, deserializedTree.left.val);
        Assert.assertEquals(3, deserializedTree.right.val);
        Assert.assertEquals(4, deserializedTree.right.left.val);
        Assert.assertEquals(5, deserializedTree.right.right.val);

        Assert.assertNull(deserializedTree.left.left);
        Assert.assertNull(deserializedTree.left.right);
        Assert.assertNull(deserializedTree.right.left.left);
        Assert.assertNull(deserializedTree.right.left.right);
        Assert.assertNull(deserializedTree.right.right.left);
        Assert.assertNull(deserializedTree.right.right.right);
    }

    @Test
    public void test2() {
        String data = serialize(null);
        TreeNode deserializedTree = deserialize(data);

        Assert.assertNull(deserializedTree);
    }
}
