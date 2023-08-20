package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/basic-calculator-iii
public class BasicCalculatorIII {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char prevSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0');
            } else if (ch == '(') {
                int end = i + 1;
                while (s.charAt(end) != ')') {
                    end++;
                }
                String expression = s.substring(i + 1, end);
                num = calculate(expression);
                i = end;
            }

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == s.length() - 1) {
                if ('+' == prevSign) {
                    stack.push(num);
                } else if ('-' == prevSign) {
                    stack.push(-num);
                } else if ('*' == prevSign) {
                    stack.push(stack.pop() * num);
                } else if ('/' == prevSign) {
                    stack.push(stack.pop() / num);
                }

                prevSign = ch;
                num = 0;
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
        Assert.assertEquals(21, calculate("2*(5+5*2)/3+(6/2+8)"));
    }
}
