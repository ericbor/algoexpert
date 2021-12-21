package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    // two pointers: O(N), O(1)
    public int trap2(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            if (height[start] <= height[end]) {
                int current = height[start];
                start++;

                while (height[start] < current) {
                    result += current - height[start];
                    start++;
                }
            } else {
                int current = height[end];
                end--;
                while (height[end] < current) {
                    result += current - height[end];
                    end--;
                }
            }
        }

        return result;
    }

    //DP: O(N), O(N)
    public int trap3(int[] height) {

        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;
    }

    //Stack: O(N), O(N)
    public int trap(int[] height) {
        int result = 0;
        int current = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                result += distance * boundedHeight;
            }

            stack.push(current);
            current++;
        }

        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(9, trap(new int[] { 4, 2, 0, 3, 2, 5 }));
    }
}
