package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

public class MoveZeroes {
    public void moveZeroes2(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] != 0) {
                i++;
            } else {
                int nextNonZeroIdx = i;
                while (nextNonZeroIdx < nums.length && nums[nextNonZeroIdx] == 0) {
                    nextNonZeroIdx++;
                }

                if (nextNonZeroIdx < nums.length) {
                    swap(nums, i, nextNonZeroIdx);
                } else {
                    i++;
                }

            }
        }
    }

    public void moveZeroes(int[] nums) {

        int nonZeroIdz = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, nonZeroIdz);
                nonZeroIdz++;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test() {
        int[] result = { 0, 1, 0, 3, 12 };
        moveZeroes(result);
        Assert.assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, result);
    }

    @Test
    public void test2() {
        int[] result = { 5, 1, 0, 3, 0, 12 };
        moveZeroes(result);
        Assert.assertArrayEquals(new int[] { 5, 1, 3, 12, 0, 0 }, result);
    }
}
