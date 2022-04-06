package leetcode.tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.NodeP;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
public class LowestCommonAncestorOfBinaryTreeIII {
    public NodeP lowestCommonAncestor(NodeP p, NodeP q) {

        Set<NodeP> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = p.parent;
        }

        while (!ancestors.contains(q)) {
            q = q.parent;
        }

        return q;
    }

    @Test
    public void test() {
        NodeP root = new NodeP(3, null);
        root.left = new NodeP(5, root);
        root.right = new NodeP(1, root);
        root.left.left = new NodeP(6, root.left);
        root.left.right = new NodeP(2, root.left);
        root.right.left = new NodeP(0, root.right);
        root.right.right = new NodeP(8, root.right);
        root.left.right.left = new NodeP(7, root.left.right);
        root.left.right.right = new NodeP(4, root.left.right);

        Assert.assertEquals(root, lowestCommonAncestor(root.left, root.right));
    }
}
