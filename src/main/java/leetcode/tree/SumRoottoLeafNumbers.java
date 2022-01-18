package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class SumRoottoLeafNumbers {
    private final List<String> sumList = new ArrayList<>();

    public int sumNumbers_DFS(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        //sb.append(root.val);

        dfs(root, "");

        int totalSum = 0;
        for (String sum : sumList) {
            totalSum += Integer.parseInt(sum);
        }

        return totalSum;
    }

    private void dfs(TreeNode node, String sum) {
        if (node == null) {
            return;
        }

        sum += node.val;
        if (node.left == null && node.right == null) {
            sumList.add(sum);
        } else {
            dfs(node.left, sum);
            dfs(node.right, sum);
        }
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, String.valueOf(root.val)));

        int totalSum = 0;

        while (!stack.isEmpty()) {
            Pair curr = stack.pop();
            TreeNode node = curr.node;
            String sum = curr.sum;

            if (node.left == null && node.right == null) {
                totalSum += Integer.parseInt(sum);
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, sum + node.left.val));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, sum + node.right.val));
            }
        }

        return totalSum;
    }

    class Pair {
        TreeNode node;
        String sum;

        public Pair(TreeNode node, String sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);

        Assert.assertEquals(1026, sumNumbers(root));
    }
}
