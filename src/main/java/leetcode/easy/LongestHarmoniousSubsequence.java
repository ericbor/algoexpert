package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-harmonious-subsequence/
public class LongestHarmoniousSubsequence {
    public int findLHS2(int[] nums) {
        int longest = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                } else if (nums[j] + 1 == nums[i]) {
                    count++;
                    flag = true;
                }
            }

            if (flag) {
                longest = Math.max(count, longest);
            }
        }

        return longest;
    }

    public int findLHS(int[] nums) {
        Map< Integer, Integer > map = new HashMap < > ();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int longest = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (map.containsKey(key + 1)) {
                longest = Math.max(longest, entry.getValue() + map.get(key + 1));
            }
        }
        return longest;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, findLHS(new int[] { 1, 2, 1, 3, 0, 0, 2, 2, 1, 3, 3 }));
    }
}
