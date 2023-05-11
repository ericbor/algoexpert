package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/move-zeroes
public class MoveZerosToEnd {

    public int[] moveZeroes(int[] nums) {

        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[zeroIndex];
                nums[zeroIndex] = nums[i];
                nums[i] = temp;
                zeroIndex++;
            }
        }

        return nums;
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, moveZeroes(new int[]{1, 0, 3, 0, 12}));
    }
}
