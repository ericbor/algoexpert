package leetcode.design.treebuilder;

public class NumericNode extends Node {
    private final int value;

    public NumericNode(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}
