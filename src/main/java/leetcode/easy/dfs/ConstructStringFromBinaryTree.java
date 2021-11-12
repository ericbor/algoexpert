package leetcode.easy.dfs;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/construct-string-from-binary-tree/
public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        Set<TreeNode> visited = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (visited.contains(curr)) {
                stack.pop();
                sb.append(")");
            } else {
                visited.add(curr);
                sb.append("(").append(curr.val);

                if (curr.left == null && curr.right != null) {
                    sb.append("()");
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }

        return sb.substring(1, sb.length() - 1);
    }

    public String tree2strRec(TreeNode root) {
        if(root == null) {
            return "";
        }

        if(root.left == null && root.right == null) {
            return String.valueOf(root.val);
        }

        if(root.right == null) {
            return root.val + "(" + tree2strRec(root.left) + ")";
        }

        return root.val + "(" + tree2strRec(root.left) + ")(" + tree2strRec(root.right) + ")";
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        Assert.assertEquals("1(2(4))(3)", tree2str(root));
        Assert.assertEquals("1(2(4))(3)", tree2strRec(root));
    }
}
