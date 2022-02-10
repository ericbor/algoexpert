package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/two-sum-bsts/
public class TwoSumBSTs {
    private final Map<Integer, Boolean> hash = new HashMap<>();

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if (root1 == null || root2 == null) {
            return false;
        }
        int sum = root1.val + root2.val;
        /*if (hash.containsKey(sum)) {
            return hash.get(sum);
        }*/

        if (sum == target) {
            //hash.put(sum, true);
            return true;
        }
        //hash.put(sum, false);

        if (sum < target) {
            return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);
        }

        return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
    }

    public boolean twoSumBSTs_REC(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = inHashset(root1, target, new HashSet<>());
        return inCheck(root2, set);
    }

    private Set<Integer> inHashset(TreeNode r, int target, Set<Integer> set) {
        if (r == null) {
            return set;
        }
        inHashset(r.left, target, set);
        set.add(target - r.val);
        inHashset(r.right, target, set);
        return set;
    }

    private boolean inCheck(TreeNode node, Set<Integer> set) {
        if (node == null) {
            return false;
        }

        boolean hasLeft = inCheck(node.left, set);
        boolean has = set.contains(node.val);
        boolean hasRight = inCheck(node.right, set);

        return hasLeft || has || hasRight;
    }

    @Test
    public void test() {
        TreeNode t1 = new TreeNode(2);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(4);

        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(0);
        t2.right = new TreeNode(3);

        Assert.assertTrue(twoSumBSTs_REC(t1, t2, 5));
        Assert.assertTrue(twoSumBSTs(t1, t2, 5));
    }

    @Test
    public void test2() {
        TreeNode t1 = new TreeNode(0);
        t1.left = new TreeNode(-10);
        t1.right = new TreeNode(10);

        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(7);
        t2.left.left = new TreeNode(0);
        t2.left.right = new TreeNode(2);

        Assert.assertFalse(twoSumBSTs_REC(t1, t2, 18));
        Assert.assertFalse(twoSumBSTs(t1, t2, 18));
    }

    @Test
    public void test3() {
        TreeNode t1 = new TreeNode(0);
        t1.left = new TreeNode(-10);
        t1.right = new TreeNode(10);

        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(7);
        t2.left.left = new TreeNode(0);
        t2.left.right = new TreeNode(2);

        Assert.assertFalse(twoSumBSTs(t1, t2, 5));
    }


}
