package leetcode.design;

public class DivideNode extends OperandNode {
    public DivideNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return leftNode.evaluate() / rightNode.evaluate();
    }
}
