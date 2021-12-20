package leetcode.design;

public abstract class OperandNode extends Node{
    protected final Node leftNode;
    protected final Node rightNode;

    protected OperandNode(Node leftNode, Node rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
