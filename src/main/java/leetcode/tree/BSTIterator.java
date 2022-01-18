package leetcode.tree;

import org.junit.Assert;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//https://leetcode.com/problems/binary-search-tree-iterator/
public class BSTIterator {
    private final List<Integer> values = new ArrayList<>();
    private int index = 0;

    public BSTIterator(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            values.add(root.val);
            root = root.right;
        }
    }

    public int next() {
        int val = values.get(index);
        index++;

        return val;
    }

    public boolean hasNext() {
        return index < values.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        Assert.assertEquals(3, iterator.next());
        Assert.assertEquals(7, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(9, iterator.next());
        Assert.assertEquals(15, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(20, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }
}
