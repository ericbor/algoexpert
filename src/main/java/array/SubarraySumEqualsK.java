package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public int subarraySum_2(int[] nums, int k) {
        Map< Integer, Integer > map = new HashMap< >();
        map.put(0, 1);

        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, subarraySum(new int[]{1,-1, 0}, 0));
        Assert.assertEquals(3, subarraySum_2(new int[]{1,-1, 0}, 0));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, subarraySum(new int[]{1,1,1}, 2));
        Assert.assertEquals(2, subarraySum_2(new int[]{1,1,1}, 2));
    }
}
