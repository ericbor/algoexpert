package leetcode.design;

public class MultiplyNode extends OperandNode {
    public MultiplyNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return leftNode.evaluate() * rightNode.evaluate();
    }
}
