package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/increasing-triplet-subsequence
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;

        for (int n: nums) {
            if (n <= firstNum) {
                firstNum = n;
            } else if (n <= secondNum) {
                secondNum = n;
            } else {
                return true;
            }
        }

        return false;
    }

    @Test
    public void test2() {
        Assert.assertTrue(increasingTriplet(new int[]{1,2,3,4,5}));
    }

    @Test
    public void test() {
        Assert.assertTrue(increasingTriplet(new int[]{20,100,10,12,5,13}));
    }
}
