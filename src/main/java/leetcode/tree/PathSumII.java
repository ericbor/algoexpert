package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/path-sum-ii/
public class PathSumII {

    List<List<Integer>> pathsList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recurseTree(root, sum, new ArrayList<>());

        return pathsList;
    }

    private void recurseTree(TreeNode node, int remainingSum, List<Integer> pathNodes) {
        if (node == null) {
            return;
        }

        // Add the current node to the path's list
        pathNodes.add(node.val);

        // Check if the current node is a leaf and also, if it
        // equals our remaining sum. If it does, we add the path to
        // our list of paths
        if (node.left == null && node.right == null && remainingSum == node.val) {
            pathsList.add(new ArrayList<>(pathNodes));
        } else {

            // Else, we will recurse on the left and the right children
            this.recurseTree(node.left, remainingSum - node.val, pathNodes);
            this.recurseTree(node.right, remainingSum - node.val, pathNodes);
        }

        // We need to pop the node once we are done processing ALL of it's subtrees.
        pathNodes.remove(pathNodes.size() - 1);
    }

    public List<List<Integer>> pathSum_2(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        Map<TreeNode, List<Integer>> pathMap = new HashMap<>();
        pathMap.put(root, list);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            List<Integer> currPath = pathMap.get(curr);

            if (curr.left == null && curr.right == null) {
                if (curr.val == targetSum) {
                    results.add(currPath);
                }
            }

            if (curr.right != null) {
                List<Integer> rightPath = new ArrayList<>(currPath);
                rightPath.add(curr.right.val);
                pathMap.put(curr.right, rightPath);

                curr.right.val = curr.right.val + curr.val;
                queue.add(curr.right);
            }

            if (curr.left != null) {
                List<Integer> leftPath = new ArrayList<>(currPath);
                leftPath.add(curr.left.val);
                pathMap.put(curr.left, leftPath);

                curr.left.val = curr.left.val + curr.val;
                queue.add(curr.left);
            }
        }

        return results;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Assert.assertEquals(List.of(List.of(5, 8, 4, 5), List.of(5, 4, 11, 2)), pathSum_2(root, 22));
    }
}
