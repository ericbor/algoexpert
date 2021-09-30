package educative.cyclicsort.easy;

import org.junit.Assert;
import org.junit.Test;

/*
We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
The array has only one duplicate but it can be repeated multiple times.
Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.

Input: [1, 4, 4, 3, 2] ... Output: 4
 */
public class FindDuplicate {
    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int currVal = nums[i];
            if (nums[i] != i + 1) {
                if (nums[i] != nums[currVal - 1]) {
                    swap(nums, i, currVal - 1);
                } else {
                    return nums[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void verify() {
        Assert.assertEquals(4, findNumber(new int[] { 1, 4, 4, 3, 2 }));
        Assert.assertEquals(3, findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        Assert.assertEquals(4, findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
