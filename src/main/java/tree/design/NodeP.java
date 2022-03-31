package tree.design;

public class NodeP {
    public int val;
    public NodeP left;
    public NodeP right;
    public NodeP parent;

    public NodeP(int val) {
        this.val = val;
    }

    public NodeP(int val, NodeP parent) {
        this.val = val;
        this.parent = parent;
    }

    public NodeP() {
    }
}
