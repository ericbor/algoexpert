package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/remove-element
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int counter = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[counter] = nums[i];
                counter++;
            }
        }

        return counter;
    }

    public int removeElement2(int[] nums, int val) {
        int leftIdx = 0;
        int rightIdx = nums.length;

        while(leftIdx < rightIdx) {
            if(nums[leftIdx] == val) {
                nums[leftIdx] = nums[rightIdx - 1];

                rightIdx--;
            } else {
                leftIdx++;
            }
        }

        return rightIdx;
    }

    @Test
    public void verify() {
        //Assert.assertEquals(2, removeElement(new int[] { 3,2,2,3 }, 3));
        //Assert.assertEquals(5, removeElement(new int[] { 0,1,2,2,3,0,4,2 }, 2));
        //Assert.assertEquals(0, removeElement(new int[] { 3 }, 3));

        //Assert.assertEquals(2, removeElement2(new int[] { 3,2,2,3 }, 3));
        Assert.assertEquals(5, removeElement2(new int[] { 0,1,2,2,3,0,4,2 }, 2));
        //Assert.assertEquals(0, removeElement2(new int[] { 3 }, 3));
    }
}
