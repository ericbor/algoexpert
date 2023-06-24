package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // deal with edge case(s)
        if(preorder.length == 0) {
            return null;
        }

        // build a map of the indices of the values as they appear in the inorder array
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        int value = preorder[0];
        TreeNode root = new TreeNode(value);
        stack.push(root);

        for(int i = 1; i < preorder.length; i++) {
            value = preorder[i];
            TreeNode node = new TreeNode(value);

            if(map.get(value) < map.get(stack.peek().val)) {
                // the new node is on the left of the last node, so it must be its left child (that's the way preorder works)
                stack.peek().left = node;
            } else {
                // the new node is on the right of the last node,
                // so it must be the right child of either the last node or one of the last node's ancestors.
                // Pop the stack until we either run out of ancestors
                // or the node at the top of the stack is to the right of the new node
                TreeNode parent = null;
                while (!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }

            stack.push(node);
        }

        return root;
    }

    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) {
            return null;
        }

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex];
        preorderIndex++;
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }

    @Test
    public void test() {
        TreeNode root = buildTree2(new int[]{3,9,1,2, 20,15,7}, new int[]{1,9,2,3,15,20,7});

        Assert.assertEquals(3, root.val);
        Assert.assertEquals(9, root.left.val);
        Assert.assertEquals(1, root.left.left.val);
        Assert.assertEquals(2, root.left.right.val);
        Assert.assertEquals(20, root.right.val);
        Assert.assertEquals(15, root.right.left.val);
        Assert.assertEquals(7, root.right.right.val);
        Assert.assertNull(root.right.left.left);
        Assert.assertNull(root.right.left.right);
        Assert.assertNull(root.right.right.left);
        Assert.assertNull(root.right.right.right);
    }
}
