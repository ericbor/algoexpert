package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/most-frequent-subtree-sum/editorial/
public class MostFrequentSubtreeSum {
    private final Map<Integer, Integer> sumToFreq = new HashMap<>();
    int highestFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        subtreeSum(root);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumToFreq.entrySet()) {
            if (entry.getValue() == highestFreq) {
                res.add(entry.getKey());
            }
        }

        int[] results = new int[res.size()];
        for (int i = 0; i < results.length; i++) {
            results[i] = res.get(i);
        }

        return results;
    }

/*    private int findTreeSum(TreeNode node) {
        if(node == null) {
            return 0;
        }

        return node.val + findTreeSum(node.left) + findTreeSum(node.right);
    }

    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }

        int sum = findTreeSum(node);
        sumToFreq.put(sum, sumToFreq.getOrDefault(sum, 0) + 1);
        highestFreq = Math.max(highestFreq, sumToFreq.get(sum));

        dfs(node.left);
        dfs(node.right);
    }*/

    private int subtreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Get left and right subtree's sum.
        int leftSubtreeSum = subtreeSum(root.left);
        int rightSubtreeSum = subtreeSum(root.right);

        // Use child's tree's sums to get current root's tree's sum
        int currSum = root.val + leftSubtreeSum + rightSubtreeSum;

        sumToFreq.put(currSum, sumToFreq.getOrDefault(currSum, 0) + 1);
        highestFreq = Math.max(highestFreq, sumToFreq.get(currSum));

        return currSum;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        Assert.assertArrayEquals(new int[]{2, -3, 4}, findFrequentTreeSum(root));
    }
}
