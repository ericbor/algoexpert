package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.design.NodeP;

public class InorderSuccessorInBSTII {
    public NodeP inorderSuccessor(NodeP x) {
        // the successor is somewhere lower in the right subtree
        if (x.right != null) {
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }

        // the successor is somewhere upper in the tree
        while (x.parent != null && x == x.parent.right) {
            x = x.parent;
        }

        return x.parent;
    }

    @Test
    public void test() {
        NodeP root = new NodeP(5, null);
        root.right = new NodeP(6, root);
        root.left = new NodeP(3, root);
        root.left.right = new NodeP(4, root.left);
        root.left.left = new NodeP(2, root.left);
        root.left.left.left = new NodeP(1, root.left.left);

        Assert.assertEquals(root, inorderSuccessor(root.left.right));
    }

    @Test
    public void test2() {
        NodeP root = new NodeP(5);
        root.right = new NodeP(6);
        root.left = new NodeP(3);
        root.left.right = new NodeP(4);
        root.left.left = new NodeP(2);
        root.left.left.left = new NodeP(1);

        Assert.assertNull(inorderSuccessor(root.right));
    }
}
