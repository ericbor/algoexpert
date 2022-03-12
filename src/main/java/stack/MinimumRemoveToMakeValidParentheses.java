package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        // Put any indexes remaining on stack into the set.
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("ab(c)d", minRemoveToMakeValid("a)b(c)d"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("lee(t(c)o)de", minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("", minRemoveToMakeValid("))(("));
    }
}
