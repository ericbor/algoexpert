package leetcode.amazon.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int k = 0; k < nums2.length; k++) {
                if (nums1[i] == nums2[k]) {

                    k++;
                    while (k < nums2.length) {
                        if (nums1[i] < nums2[k]) {
                            results[i] = nums2[k];
                            break;
                        }
                        k++;
                    }

                    if (results[i] == 0) {
                        results[i] = -1;
                    }
                    break;
                }
            }
        }

        return results;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            for(int k = i + 1; k < nums2.length; k++) {
                if(nums2[k] > nums2[i]) {
                    map.put(nums2[i], nums2[k]);
                    break;
                }
            }
            if(!map.containsKey(nums2[i])) {
                map.put(nums2[i], -1);
            }
        }

        int[] results = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            results[j] = map.get(nums1[j]);

        }

        return results;
    }

    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), - 1);
        }

        int[] results = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            results[i] = map.get(nums1[i]);
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { -1, 3, -1 }, nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[] { -1, 3, -1 }, nextGreaterElement2(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[] { -1, 3, -1 }, nextGreaterElement3(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 }));
    }
}
