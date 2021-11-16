package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {

        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < nums.length; i++) {
            int previousNum = nums[nextNonDuplicate - 1];
            int currentNum = nums[i];

            if (previousNum != currentNum) {
                //swap
                nums[nextNonDuplicate] = nums[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
    }
}
