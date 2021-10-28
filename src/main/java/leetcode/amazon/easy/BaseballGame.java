package leetcode.amazon.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/baseball-game/
public class BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> stack = new ArrayList<>();

        for (String score : ops) {
            char c = score.charAt(0);
            if (Character.isDigit(c) || c == '-') {
                Integer digit = Integer.parseInt(score);
                stack.add(digit);
            } else if (c == 'C') {
                int indexToRemove = stack.size() - 1;
                stack.remove(indexToRemove);
            } else if (c == 'D') {
                Integer toAdd = stack.get(stack.size() - 1) * 2;
                stack.add(toAdd);
            } else if (c == '+') {
                Integer last = stack.get(stack.size() - 1);
                Integer beforeLast = stack.get(stack.size() - 2);
                Integer sum = last + beforeLast;
                stack.add(sum);
            }
        }

        int sum = 0;
        for (int num : stack) {
            sum += num;
        }

        return sum;
    }

    @Test
    public void test() {
        Assert.assertEquals(27, calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
    }
}
