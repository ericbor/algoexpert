package leetcode.design;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function
public class TreeBuilder {
    public Node buildTree(String[] postfix) {
        Deque<Node> stack = new ArrayDeque<>();

        for (String s : postfix) {
            if (Character.isDigit(s.charAt(0))) {
                stack.push(new NumericNode(Integer.parseInt(s)));
            } else {
                Node right = stack.pop();
                Node left = stack.pop();

                stack.push(OperandNodeFactory.createNode(s, left, right));
            }
        }

        return stack.peek();
    }

    @Test
    public void test() {
        Node node = buildTree(new String[] { "3", "4", "+", "2", "*", "7", "/" });

        Assert.assertEquals(2, node.evaluate());
    }

    @Test
    public void test2() {
        Node node = buildTree(new String[] { "4", "5", "2", "7", "+", "-", "*" });

        Assert.assertEquals(-16, node.evaluate());
    }

    @Test
    public void test3() {
        Node node = buildTree(new String[] { "4", "2", "+", "3", "5", "1", "-", "*", "+" });

        Assert.assertEquals(18, node.evaluate());
    }
}
