package tree.easy;

import tree.design.TreeNode;

import java.util.ArrayList;
import java.util.List;

//Depth First Search
public class PostOrderTraversal {
    /*
     *  LEFT-RIGHT-ROOT: A-C-B
     *
     *       B
     *      / \
     *     /   \
     *    A     C
     *
     * */

    public List<Integer> postOrderTraversal_Recursive(TreeNode root) {
        List<Integer> output = new ArrayList<>();

        helper(root, output);

        return output;
    }

    private void helper(TreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }

        helper(root.left, output);
        helper(root.right, output);
        output.add(root.val);
    }

}
