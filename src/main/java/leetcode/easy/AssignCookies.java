package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Set;

//https://leetcode.com/problems/assign-cookies/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;

        int counter = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                counter++;
                i++;
            }
            j++;
        }

        return counter;
    }

    private Set<String> operators = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();
        //int result = 0;
        for(String token: tokens) {
            if(operators.contains(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int currResult = 0;
                if(token == "/") {
                    currResult = num2 / num1;
                } else if(token == "*") {
                    currResult = num2 * num1;
                } else if(token == "+") {
                    currResult = num2 + num1;
                } else if(token == "-") {
                    currResult = num2 - num1;
                }
                stack.push(currResult);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();

    }

    @Test
    public void test() {
        Assert.assertEquals(6, findContentChildren(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 1, 1, 9, 8, 7, 5, 4, 3, 2, 1 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, findContentChildren(new int[] { 1, 2 }, new int[] { 1, 2, 3 }));
    }
}
