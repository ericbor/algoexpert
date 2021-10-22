package educative.dfs.easy;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConvertSortedArrayBST {
    int[] nums;

    public TreeNode convertToBST(int[] nums) {
        this.nums = nums;

        return preorder(0, nums.length - 1);
    }

    private TreeNode preorder(int left, int right) {
        if (left > right) {
            return null;
        }

        // always choose left middle node as a root
        int mid = left + (right - left) / 2;

        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[mid]);
        root.left = preorder(left, mid - 1);
        root.right = preorder(mid + 1, right);

        return root;
    }

    @Test
    public void testPreorder() {
        TreeNode result = convertToBST(new int[] { -10, -3, 0, 5, 9 });
        Assert.assertEquals(0, result.val);
        Assert.assertEquals(-10, result.left.val);
        Assert.assertEquals(5, result.right.val);
        Assert.assertEquals(-3, result.left.right.val);
        Assert.assertNull(result.left.left);
        Assert.assertEquals(9, result.right.right.val);
        Assert.assertNull(result.right.left);
    }
}
