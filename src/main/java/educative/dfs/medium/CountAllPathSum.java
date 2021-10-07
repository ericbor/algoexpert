package educative.dfs.medium;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//https://www.educative.io/courses/grokking-the-coding-interview/xV2J7jvN1or
public class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, S, currentPath);
    }

    private static int countPathsRecursive(TreeNode currentNode, int target, List<Integer> currentPath) {
        if (currentNode == null) {
            return 0;
        }

        // add the current node to the path
        currentPath.add(currentNode.val);

        int result = 0;

        // find the sums of all sub-paths in the current path list
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        int pathSum = 0;
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            // if the sum of any sub-path is equal to 'S' we increment our path count.
            if (pathSum == target) {
                result++;
            }
        }

        result += countPathsRecursive(currentNode.left, target, currentPath);
        result += countPathsRecursive(currentNode.right, target, currentPath);

        currentPath.remove(currentPath.size() - 1);

        return result;
    }

    @Test
    public void main() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        Assert.assertEquals(2, countPaths(root, 11));
    }
}
