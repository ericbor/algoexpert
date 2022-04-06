package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/
public class LowestCommonAncestorOfBinaryTreeIV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        TreeNode prev = null;
        if(nodes == null || nodes.length == 0){
            return null;
        }
        if(nodes.length == 1){
            return nodes[0];
        }
        for(int i = 0; i < nodes.length - 1; i++){
            if(prev == null){
                prev = helper(root, nodes[i], nodes[i + 1]);
            }else{
                prev = helper(root, prev, nodes[i + 1]);
            }
        }
        return prev;
    }
    private TreeNode helper(TreeNode root, TreeNode a, TreeNode b){
        if(root == null || a == root || b == root){
            return root;
        }
        TreeNode left = helper(root.left, a, b);
        TreeNode right = helper(root.right, a, b);

        if(left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Assert.assertEquals(root, lowestCommonAncestor(root.left, new TreeNode[] { root.left.right.left, root.left.left, root.left.right, root.left.right.right }));
    }
}
