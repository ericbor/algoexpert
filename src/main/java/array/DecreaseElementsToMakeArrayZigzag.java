package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/decrease-elements-to-make-array-zigzag
public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int oddCost = 0;
        int evenCost = 0;

        for (int i = 0; i < nums.length; i++) {
            int min = Integer.MAX_VALUE;

            if (i - 1 >= 0) {
                min = Math.min(min, nums[i - 1]);
            }
            if (i + 1 < nums.length) {
                min = Math.min(min, nums[i + 1]);
            }

            int cost = Math.max(0, nums[i] - min + 1);
            if (i % 2 == 0) {
                evenCost += cost;
            } else {
                oddCost += cost;
            }
        }

        return Math.min(oddCost, evenCost);
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
    }

    @Test
    public void test() {
        Assert.assertEquals(2, movesToMakeZigzag(new int[]{1, 2, 3}));
    }
}
