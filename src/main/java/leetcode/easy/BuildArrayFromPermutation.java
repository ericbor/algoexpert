package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/build-array-from-permutation/
public class BuildArrayFromPermutation {

    public static int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int idx = nums[i];
            ans[i] = nums[idx];
        }

        return ans;
    }

    private static void swap(int[]arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test() {

        Assert.assertArrayEquals(new int[] {0,1,2,4,5,3 }, buildArray(new int[] { 0,2,1,5,3,4 }));
    }
}
