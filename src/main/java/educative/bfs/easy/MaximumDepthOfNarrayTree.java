package educative.bfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
public class MaximumDepthOfNarrayTree {
    public int maxDepth(Node root) {
        int maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();
                queue.addAll(curr.children);
            }
            maxDepth++;
        }

        return maxDepth;
    }

    public int maxDepthRec(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.children.isEmpty()) {
            return 1;
        }

        List<Integer> heights = new LinkedList<>();
        for (Node node : root.children) {
            heights.add(maxDepthRec(node));
        }

        return Collections.max(heights) + 1;
    }

    @Test
    public void test() {
        Node root = new Node(1, new ArrayList<>());
        Node node1 = new Node(3, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(4, new ArrayList<>());
        root.children = List.of(node1, node2, node3);
        Node node4 = new Node(5, new ArrayList<>());
        Node node5 = new Node(6, new ArrayList<>());
        node1.children = List.of(node4, node5);

        Assert.assertEquals(3, maxDepth(root));
        Assert.assertEquals(3, maxDepthRec(root));
    }

}
