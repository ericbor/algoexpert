package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/largest-perimeter-triangle/
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }

        return 0;
    }

    @Test
    public void test() {
        Assert.assertEquals(8, largestPerimeter(new int[] { 3, 6, 2, 3 }));
    }
}
