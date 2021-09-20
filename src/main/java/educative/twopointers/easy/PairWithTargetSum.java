package educative.twopointers.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://www.educative.io/courses/grokking-the-coding-interview/xog6q15W9GP
public class PairWithTargetSum {
    //O(N), O(1)
    public static int[] search(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) {
                return new int[] { left, right }; // found the pair
            }

            if (targetSum > currentSum) {
                left++; // we need a pair with a bigger sum
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
        return new int[] { -1, -1 };
    }

    /* O(N), O(N)
    x + y = targetSum
    y = targetSum - x
     */
    public static int[] search2(int[] arr, int targetSum) {
        Map<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int y = targetSum - arr[i];
            if (nums.containsKey(y)) {
                return new int[] { nums.get(y), i };
            } else {
                nums.put(arr[i], i); // put the number and its index in the map
            }
        }
        return new int[] { -1, -1 };
    }

    @Test
    public void verify() {
        //Assert.assertArrayEquals(new int[] { 1, 3 }, search(new int[] { 1, 2, 3, 4, 6 }, 6));
        //Assert.assertArrayEquals(new int[] { 0, 2 }, search(new int[] { 2, 5, 9, 11 }, 11));

        Assert.assertArrayEquals(new int[] { 1, 3 }, search2(new int[] { 1, 2, 3, 4, 6 }, 6));
        //Assert.assertArrayEquals(new int[] { 0, 2 }, search2(new int[] { 2, 5, 9, 11 }, 11));
    }
}
