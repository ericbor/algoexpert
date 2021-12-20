package leetcode.design;

public class AddNode extends OperandNode {
    public AddNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return leftNode.evaluate() + rightNode.evaluate();
    }
}
