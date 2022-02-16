package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            stack.push(i);
        }

        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = nums[stack.peek()];
            }
            stack.push(i);
        }

        return result;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 2, 3, 4, -1, 4 }, nextGreaterElements(new int[] { 1, 2, 3, 4, 3 }));
    }

    @Test
    public void test2() {
        //Assert.assertArrayEquals(new int[] { 2, 3, 4, -1, 4 }, nextGreaterElements_BF(new int[] { 1, 2, 3, 4, 3 }));
    }
}
