package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/basic-calculator-ii/
public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (int) currentChar - (int) '0';
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(7, calculate("3+2*2"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, calculate("3/2"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(5, calculate("3+5 / 2"));
    }
}
