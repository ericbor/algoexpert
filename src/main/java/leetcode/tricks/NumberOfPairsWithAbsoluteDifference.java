package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

//https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
/*
Enhanced version of problem, where you need to find if any 2 numbers in array sum to target e.g.:
[1,2,3,4], target - 5. Answer: 1 and 4

In this problem we have to find all pairs with abs difference to target
 */
public class NumberOfPairsWithAbsoluteDifference {
    public int countKDifference(int[] nums, int target) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int k = i + 1; k < nums.length; k++) {
                int diff = Math.abs(nums[i] - nums[k]);
                if (diff == target) {
                    count++;
                }
            }
        }

        return count;
    }

    public int countKDifference2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int x = nums[i] + k;//two possible values due to abs function
            int y = nums[i] - k;
            if (map.containsKey(x)) {
                count += map.get(x);//update count
            }
            if (map.containsKey(y)) {
                count += map.get(y);//update count
            }

            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);//update map with frequency
            } else {
                map.put(n, 1);
            }
        }
        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, countKDifference(new int[] { 1, 2, 2, 1 }, 1));
        Assert.assertEquals(3, countKDifference(new int[] { 3, 2, 1, 5, 4 }, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, countKDifference2(new int[] { 1, 2, 2, 1 }, 1));
        Assert.assertEquals(3, countKDifference2(new int[] { 3, 2, 1, 5, 4 }, 2));
    }
}
