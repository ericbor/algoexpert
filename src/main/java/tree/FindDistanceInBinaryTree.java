package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.TreeNode;

import java.util.*;

//https://leetcode.com/problems/find-distance-in-a-binary-tree
public class FindDistanceInBinaryTree {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = lowestCommonAncestor(root, p, q); // step 1: find lca
        int h1 = findDepth(lca, p, 0); // step 2: find level of p from lca
        int h2 = findDepth(lca, q, 0); // step 2: find level of q from lca

        return h1 + h2; // level 3: add up the level from lca
    }

    // find the level of node p
    private int findDepth(TreeNode root, int p, int index) {
        if (root == null) {
            return 0;
        }
        if (root.val == p) {
            return index;
        }
        int d = findDepth(root.left, p, index + 1);
        // if d is 0, p was not found in previous nodes, so go to the other side;
        //if d is not 0, then p was found, then just return d, which is the level of p
        if (d == 0) {
            d = findDepth(root.right, p, index + 1);
        }
        return d;
    }
    // find LCA
    private TreeNode lowestCommonAncestor(TreeNode node, Integer p, Integer q) {
        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        childToParent.put(node, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        TreeNode pNode = node.val == p ? node : null;
        TreeNode qNode = node.val == q ? node : null;

        while(pNode == null || qNode == null) {
            TreeNode curr = queue.poll();
            if(curr.left != null) {
                queue.add(curr.left);
                childToParent.put(curr.left, curr);
                if(curr.left.val == p) {
                    pNode = curr.left;
                }
                if(curr.left.val == q) {
                    qNode = curr.left;
                }
            }
            if(curr.right != null) {
                queue.add(curr.right);
                childToParent.put(curr.right, curr);
                if(curr.right.val == p) {
                    pNode = curr.right;
                }
                if(curr.right.val == q) {
                    qNode = curr.right;
                }
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while(pNode != null) {
            ancestors.add(pNode);
            pNode = childToParent.get(pNode);
        }

        while(!ancestors.contains(qNode)) {
            qNode = childToParent.get(qNode);
        }

        return qNode;
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(20);

        Assert.assertEquals(1, findDistance(root, 15, 20));

    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        Assert.assertEquals(3, findDistance(root, 5, 0));

    }

}
