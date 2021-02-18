package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSumSorted {
    //Time: O(n), Space: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            int currentSum = numbers[leftIndex] + numbers[rightIndex];
            if (currentSum == target) {
                return new int[] { leftIndex + 1, rightIndex + 1 };
            } else if (currentSum > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }

        return new int[] { -1, -1 };
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { 1, 2 }, twoSum(new int[] { 2, 7, 11, 15 }, 9));
        Assert.assertArrayEquals(new int[] { 1, 3 }, twoSum(new int[] { 2, 3, 4 }, 6));
        Assert.assertArrayEquals(new int[] { 1, 2 }, twoSum(new int[] { -1, 0 }, -1));
    }
}
