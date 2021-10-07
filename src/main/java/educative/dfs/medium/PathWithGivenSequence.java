package educative.dfs.medium;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

//https://www.educative.io/courses/grokking-the-coding-interview/m280XNlPOkn
public class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        // TODO: Write your code here
        return find(root, sequence, 0);
    }

    private static boolean find(TreeNode currNode, int[] sequence, int sequenceIndex) {
        if (currNode == null) {
            return false;
        }

        if (sequenceIndex >= sequence.length || currNode.val != sequence[sequenceIndex]) {
            return false;
        }

        // if the current node is a leaf, add it is the end of the sequence, we have found a path!
        if (currNode.left == null && currNode.right == null && sequenceIndex == sequence.length - 1) {
            return true;
        }

        boolean leftResult = find(currNode.left, sequence, sequenceIndex + 1);
        boolean rightResult = find(currNode.right, sequence, sequenceIndex + 1);

        return leftResult || rightResult;
    }

    @Test
    public void main() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        Assert.assertFalse(findPath(root, new int[] { 1, 0, 7 }));
        Assert.assertTrue(findPath(root, new int[] { 1, 1, 6 }));
    }
}
