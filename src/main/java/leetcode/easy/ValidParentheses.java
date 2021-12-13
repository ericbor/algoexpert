package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                if(stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
    }

    @Test
    public void test() {
        Assert.assertTrue(isValid("({[]})"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isValid("()[]{}"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isValid("({})[]{}"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(isValid("({})[{}"));
    }
}
