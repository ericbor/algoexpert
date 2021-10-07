package educative.dfs.medium;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://www.educative.io/courses/grokking-the-coding-interview/YQ5o5vEXP69
public class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        return findRootToLeafPathNumbers(root, 0);
    }

    private static int findRootToLeafPathNumbers(TreeNode curr, int pathSum){
        if(curr == null){
            return 0;
        }

        // calculate the path number of the current node
        int currentSum = 10 * pathSum + curr.val;

        // if the current node is a leaf, return the current path sum.
        if(curr.left == null && curr.right == null){
            return currentSum;
        }

        // traverse the left and the right sub-tree
        int leftSideSum = findRootToLeafPathNumbers(curr.left, currentSum);
        int rightSideSum = findRootToLeafPathNumbers(curr.right, currentSum);

        return leftSideSum + rightSideSum;
    }

    @Test
    public void verify() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        Assert.assertEquals(332, findSumOfPathNumbers(root));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(9);
        root2.right.left = new TreeNode(2);
        root2.right.right = new TreeNode(9);
        Assert.assertEquals(408, findSumOfPathNumbers(root2));
    }
}
