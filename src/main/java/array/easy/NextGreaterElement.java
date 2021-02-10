package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num2 : nums2) {
            while (!stack.isEmpty() && num2 > stack.peek()) {
                map.put(stack.pop(), num2);
            }
            stack.push(num2);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        int[] results = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            results[i] = map.get(nums1[i]);
        }

        return results;
    }

    @Test
    public void verify() {
        //Assert.assertArrayEquals(new int[] { -1, 3, -1 }, nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));
        Assert.assertArrayEquals(new int[] { 7,7,7,7,7}, nextGreaterElement(new int[] { 1,3,5,2,4 }, new int[] { 6,5,4,3,2,1,7 }));
    }
}
