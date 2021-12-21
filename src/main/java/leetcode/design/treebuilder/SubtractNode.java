package leetcode.design.treebuilder;

public class SubtractNode extends OperandNode {
    public SubtractNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return leftNode.evaluate() - rightNode.evaluate();
    }
}
