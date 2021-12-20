package leetcode.design;

public final class OperandNodeFactory {
    private OperandNodeFactory() {
    }

    public static OperandNode createNode(String operand, Node left, Node right) {
        if ("+".equals(operand)) {
            return new AddNode(left, right);
        }
        if ("-".equals(operand)) {
            return new SubtractNode(left, right);
        }
        if ("*".equals(operand)) {
            return new MultiplyNode(left, right);
        }
        if ("/".equals(operand)) {
            return new DivideNode(left, right);
        }

        throw new UnsupportedOperationException("operand not supported");
    }
}
