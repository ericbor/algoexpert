import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String curr : tokens) {
            if (isDigit(curr)) {
                stack.push(Integer.parseInt(curr));
            } else {
                int first = stack.pop();
                int second = stack.pop();
                int result = apply(second, first, curr);
                stack.push(result);
            }
        }

        return stack.peek();
    }

    private boolean isDigit(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int apply(int a, int b, String op) {
        if ("+".equals(op)) {
            return a + b;
        }
        if ("-".equals(op)) {
            return a - b;
        }
        if ("*".equals(op)) {
            return a * b;
        }
        if ("/".equals(op)) {
            return a / b;
        }

        throw new UnsupportedOperationException("wrong");
    }

    @Test
    public void test3() {
        Assert.assertEquals(22, evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(6, evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    @Test
    public void test() {
        Assert.assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
