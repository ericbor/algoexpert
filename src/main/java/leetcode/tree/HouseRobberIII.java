package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/house-robber-iii/
public class HouseRobberIII {
    public int rob(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int oddSum = 0;
        int evenSum = 0;
        int row = 1;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            int currSum = 0;

            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                currSum += curr.val;

                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }

            if(row % 2 == 0) {
                evenSum += currSum;
            } else {
                oddSum += currSum;
            }
            row++;
        }

        return Math.max(oddSum, evenSum);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);

        Assert.assertEquals(7, rob(root));
    }
}
