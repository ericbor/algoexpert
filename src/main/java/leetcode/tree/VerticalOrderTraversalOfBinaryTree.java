package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<TreeNode, Integer> columnByNode = new HashMap<>();
        columnByNode.put(root, 0);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int minColumn = 0;
        int row = 0;

        Map<Integer, Queue<Pair>> columnValues = new HashMap<>();
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                int currColumn = columnByNode.get(curr);

                if (!columnValues.containsKey(currColumn)) {
                    columnValues.put(currColumn, new PriorityQueue<>((a, b) -> {
                        if (a.row == b.row) {
                            return a.val - b.val;
                        }

                        return a.row - b.row;
                    }));
                }
                columnValues.get(currColumn).add(new Pair(row, curr.val));

                if (curr.left != null) {
                    columnByNode.put(curr.left, currColumn - 1);
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    columnByNode.put(curr.right, currColumn + 1);
                    queue.add(curr.right);
                }

                minColumn = Math.min(minColumn, currColumn);
            }
            row++;

        }

        List<List<Integer>> results = new ArrayList<>(columnValues.size());
        while (columnValues.containsKey(minColumn)) {
            Queue<Pair> pairs = columnValues.get(minColumn);
            List<Integer> result = new ArrayList<>(pairs.size());
            while (!pairs.isEmpty()) {
                result.add(pairs.poll().val);
            }
            results.add(result);
            minColumn++;
        }

        return results;
    }

    class Pair {
        int row;
        int val;

        public Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(List.of(List.of(4), List.of(2), List.of(1, 5, 6), List.of(3), List.of(7)), verticalTraversal(root));
    }
}
