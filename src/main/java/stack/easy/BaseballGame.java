package stack.easy;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/baseball-game/
public class BaseballGame {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String op : ops) {
            if ("+".equals(op)) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if ("D".equals(op)) {
                int previousScore = stack.peek();
                stack.push(2 * previousScore);
            } else if ("C".equals(op)) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int result = 0;
        for (int score : stack) {
            result += score;
        }

        return result;
    }
}
