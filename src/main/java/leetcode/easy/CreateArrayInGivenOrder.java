package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/create-target-array-in-the-given-order/
public class CreateArrayInGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        for (int i = 0; i < nums.length; i++) {
            if (i != index[i]) {
                swap(nums, i, index[i]);
            }
        }

        return nums;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 0, 4, 1, 3, 2 }, createTargetArray(new int[] { 0, 1, 2, 3, 4 }, new int[] { 0, 1, 2, 2, 1 }));
        Assert.assertArrayEquals(new int[] { 0, 1, 2, 3, 4 }, createTargetArray(new int[] { 1, 2, 3, 4, 0 }, new int[] { 0, 1, 2, 3, 0 }));
    }
}
