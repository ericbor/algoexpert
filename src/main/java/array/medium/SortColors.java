package array.medium;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/sort-colors
public class SortColors {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int i = 0;

        while(i <= twoIndex) {
            if(nums[i] == 0) {
                swap(nums, zeroIndex, i);
                zeroIndex++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, twoIndex, i);
                twoIndex--;
            } else {
                i++;
            }
        }
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    @Test
    public void test2() {
        int[] arr = {2,0,1};
        sortColors(arr);
        Assert.assertArrayEquals(new int[] {0,1,2}, arr);
    }

    @Test
    public void test() {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        Assert.assertArrayEquals(new int[] {0,0,1,1,2,2}, arr);
    }
}
