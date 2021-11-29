package leetcode.easy.binarysearch;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        //the loop will be stopped at the moment when:
        // `start` < `end` and
        // nums[start] < target < nums[end]
        return start;
    }


    @Test
    public void test2() {
        Assert.assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));
    }

    @Test
    public void test4() {
        Assert.assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));
    }

    @Test
    public void test5() {
        Assert.assertEquals(0, searchInsert(new int[]{1}, 0));
    }

    @Test
    public void test6() {
        Assert.assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
    }
}
