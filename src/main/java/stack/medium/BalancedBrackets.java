package stack.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        List<Character> openingBrackets = List.of('{', '[', '(');
        List<Character> closingBrackets = List.of('}', ']', ')');

        for (char c : str.toCharArray()) {
            boolean isOpeningBracket = openingBrackets.contains(c);
            boolean isClosingBracket = closingBrackets.contains(c);

            if (isOpeningBracket) {
                stack.push(c);
            } else if (isClosingBracket) {
                if (stack.isEmpty() || !bracketsMatch(c, stack.peek())) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private static boolean bracketsMatch(char current, char latestInStack) {
        boolean isMatch = false;
        if (']' == current && '[' == latestInStack) {
            isMatch = true;
        } else if (')' == current && '(' == latestInStack) {
            isMatch = true;
        } else if ('}' == current && '{' == latestInStack) {
            isMatch = true;
        }

        return isMatch;
    }

    @Test
    public void verify() {
        Assert.assertFalse(balancedBrackets("(((((({{{{{[[[[[([)])]]]]]}}}}}))))))"));
    }
}
