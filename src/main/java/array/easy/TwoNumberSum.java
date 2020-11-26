package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        //x+y=10 -> y=10-x
        Set<Integer> storage = new HashSet<>();
        for (int x : array) {
            int y = targetSum - x;//7,5,14,2,-1,9,11
            if (storage.contains(y)) {
                return new int[] { x, y };
            } else {
                storage.add(x);//3,5,-4,8,11
            }
        }

        return new int[2];
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { -1, 11 }, twoNumberSum(new int[] { 3, 5, -4, 8, 11, 1, -1, 6 }, 10));
    }
}
