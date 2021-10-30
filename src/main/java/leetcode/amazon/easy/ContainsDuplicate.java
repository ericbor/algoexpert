package leetcode.amazon.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test() {
        Assert.assertTrue(containsDuplicate(new int[] { 1, 2, 3, 1 }));
    }

    @Test
    public void test2() {
        Assert.assertFalse(containsDuplicate(new int[] { 1, 2, 3, 4 }));
    }

    @Test
    public void test3() {
        Assert.assertTrue(containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }

    @Test
    public void test4() {
        Assert.assertTrue(containsDuplicate(new int[] { 3, 3 }));
    }

    @Test
    public void test5() {
        Assert.assertFalse(containsDuplicate(new int[] { 0 }));
    }
}
