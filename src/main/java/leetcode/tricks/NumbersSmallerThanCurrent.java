package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class NumbersSmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int result = 0;
            for (int k = 0; k < nums.length; k++) {
                if (i != k) {
                    if (nums[i] > nums[k]) {
                        result++;
                    }
                }
            }

            results[i] = result;
        }

        return results;

    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        var buck = new int[101];

        // count each occurence
        for (int num : nums) { // 0,1,2,1,0,0,0,0,1
            buck[num]++;
        }

        // calc how manu numbers are smaller
        for (int i = 1; i < buck.length; i++) { // 0,1,3,4,4,4,4,4,5
            buck[i] += buck[i - 1];
        }

        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 0;
            } else {
                results[i] = buck[nums[i] - 1];
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 4, 0, 1, 1, 3 }, smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 }));
        Assert.assertArrayEquals(new int[] { 2, 1, 0, 3 }, smallerNumbersThanCurrent(new int[] { 6, 5, 4, 8 }));
        Assert.assertArrayEquals(new int[] { 0, 0, 0, 0 }, smallerNumbersThanCurrent(new int[] { 7, 7, 7, 7 }));
        Assert.assertArrayEquals(new int[] { 0, 0, 0, 0 }, smallerNumbersThanCurrent(new int[] { 5,0,10,0,10,6 }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[] { 4, 0, 1, 1, 3 }, smallerNumbersThanCurrent2(new int[] { 8, 1, 2, 2, 3 }));
        Assert.assertArrayEquals(new int[] { 2, 1, 0, 3 }, smallerNumbersThanCurrent2(new int[] { 6, 5, 4, 8 }));
        Assert.assertArrayEquals(new int[] { 0, 0, 0, 0 }, smallerNumbersThanCurrent2(new int[] { 7, 7, 7, 7 }));
    }
}
