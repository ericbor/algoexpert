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

//https://leetcode.com/problems/binary-tree-vertical-order-traversal/
public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //use a HashMap to store the TreeNode and the according cloumn value
        Map<TreeNode, Integer> columnByNode = new HashMap<>();
        columnByNode.put(root, 0);

        int min = 0;

        //columnValues's key is column, we assume the root column is zero, the left node - minus 1 ,and the right node - plus 1
        Map<Integer, List<Integer>> columnValues = new HashMap<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int currColumn = columnByNode.get(node);

            if (!columnValues.containsKey(currColumn)) {
                columnValues.put(currColumn, new ArrayList<>());
            }
            columnValues.get(currColumn).add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                columnByNode.put(node.left, currColumn - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                columnByNode.put(node.right, currColumn + 1);
            }
            //update min ,min means the minimum column value, which is the left most node
            min = Math.min(min, currColumn);
        }

        while (columnValues.containsKey(min)) {
            results.add(columnValues.get(min));
            min++;
        }

        return results;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(List.of(List.of(9), List.of(3, 15), List.of(20), List.of(7)), verticalOrder(root));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);

        Assert.assertEquals(List.of(List.of(4), List.of(9), List.of(3, 0, 1), List.of(8), List.of(7)), verticalOrder(root));
    }
}
