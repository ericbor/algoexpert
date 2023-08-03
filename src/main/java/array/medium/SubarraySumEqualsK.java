package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);// since empty array's sum is 0
        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            int compliment = sum - k;
            if (map.containsKey(compliment)) {
                count += map.get(compliment);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, subarraySum(new int[]{-1, -1, 1}, 0));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, subarraySum(new int[]{1, 2, 3}, 3));
    }
}
