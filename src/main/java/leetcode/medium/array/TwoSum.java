package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/two-sum
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];
            if (map.containsKey(y)) {
                return new int[] { map.get(y), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{0,1}, twoSum(new int[]{2,7,11,15}, 9));
    }
}
