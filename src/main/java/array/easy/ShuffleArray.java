package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/shuffle-the-array/
public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int firstHalfPointer = 0;
        int secondHalfPointer = n;

        for(int i = 0; i< nums.length -1; i += 2) {
            result[i] = nums[firstHalfPointer];
            result[i+1] = nums[secondHalfPointer];
            firstHalfPointer++;
            secondHalfPointer++;
        }

        return result;
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { 2,3,5,4,1,7 }, shuffle(new int[] { 2,5,1,3,4,7 }, 3));
    }
}
