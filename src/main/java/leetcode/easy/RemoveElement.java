package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/remove-element/
public class RemoveElement {
    public int removeElement2(int[] nums, int val) {
        int itemsCount = 0;
        for(int num: nums) {
            if(num == val) {
                itemsCount++;
            }
        }

        if(itemsCount == nums.length) {
            return 0;
        }

        if(itemsCount == 0) {
            return nums.length;
        }


        int lastIndex = nums.length - 1;
        while(nums[lastIndex] == val) {
            lastIndex--;
        }


        int currIndex = 0;
        while(currIndex < nums.length - itemsCount) {
            if(nums[currIndex] == val) {
                swap(nums, currIndex, lastIndex);

                lastIndex--;
                while(nums[lastIndex] == val) {
                    lastIndex--;
                }
            }

            currIndex++;
        }

        return currIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            if (nums[start] == val) {
                nums[start] = nums[end - 1];
                // reduce array size by one
                end--;
            } else {
                start++;
            }
        }
        return end;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, removeElement(new int[]{3,2,2,3}, 3));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, removeElement(new int[]{1}, 3));
    }

    @Test
    public void test4() {
        Assert.assertEquals(0, removeElement(new int[]{3}, 3));
    }
}
