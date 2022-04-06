package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
public class AllNodesDistanceKInBinaryTree {
    private final Map<TreeNode, List<TreeNode>> graph = new HashMap<>();

    public List<Integer> distanceK_2(TreeNode root, TreeNode target, int k) {

        buildMap(root, null);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);

        List<Integer> results = new ArrayList<>();
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            if (k == 0) {
                for (int i = 0; i < levelSize; i++) {
                    results.add(queue.poll().val);
                }
                return results;
            }

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                List<TreeNode> neighbors = graph.get(node);
                for (TreeNode neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            k--;
        }

        return results;
    }

    private void buildMap(TreeNode node, TreeNode parent) {
        graph.computeIfAbsent(node, value -> new ArrayList<>());
        if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }
        if (node.left != null) {
            buildMap(node.left, node);
        }
        if (node.right != null) {
            buildMap(node.right, node);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Map<TreeNode, TreeNode> parents = new HashMap<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == target) {
                break;
            }
            if (cur.left != null) {
                parents.put(cur.left, cur);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                parents.put(cur.right, cur);
                queue.add(cur.right);
            }
        }
        queue.clear();

        queue.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int distance = k;

        while (distance > 0) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null && !visited.contains(cur.left)) {
                    visited.add(cur.left);
                    queue.add(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    visited.add(cur.right);
                    queue.add(cur.right);
                }
                TreeNode parent = parents.get(cur);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.add(parent);
                }
            }

            distance--;
        }

        List<Integer> results = new ArrayList<>(queue.size());
        while (!queue.isEmpty()) {
            results.add(queue.poll().val);
        }

        return results;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Assert.assertEquals(Collections.emptyList(), distanceK(root, root.left, 4));
    }

    @Test
    public void test4() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Assert.assertEquals(List.of(7, 4, 1), distanceK(root, root.left, 2));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        Assert.assertEquals(List.of(), distanceK(root, root, 3));
    }

    @Test
    public void test3() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);

        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(10);

        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Assert.assertEquals(List.of(9, 10, 7, 4, 1), distanceK(root, root.left, 2));
    }
}
