package leetcode.easy.dfs;

import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/leaf-similar-trees/
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        helper(root1, list1);
        helper(root2, list2);

        return list1.equals(list2);
    }

    private void helper(TreeNode node, List<Integer> leafValues) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leafValues.add(node.val);
        } else {
            helper(node.left, leafValues);
            helper(node.right, leafValues);
        }
    }
}
