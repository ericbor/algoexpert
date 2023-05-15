package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/daily-temperatures
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] results = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            // while the stack is not empty and current day is warmer than the day referred by the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // pop the index of the colder previous day
                int prevDayIndex = stack.pop();
                // set the popped index in the res array to (current index - the popped index)
                results[prevDayIndex] = i - prevDayIndex;
            }
            // push the current index to stack
            stack.push(i);
        }
        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}
