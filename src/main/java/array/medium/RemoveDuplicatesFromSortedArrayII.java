package array.medium;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {

        int j = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

    @Test
    public void test() {
        Assert.assertEquals(7, removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
