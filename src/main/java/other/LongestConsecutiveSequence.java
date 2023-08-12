package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/longest-consecutive-sequence
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestCount = 0;
        for (int k : set) {
            if (!set.contains(k - 1)) {
                int curr = k;
                int currCount = 1;

                while (set.contains(curr + 1)) {
                    curr += 1;
                    currCount++;
                }

                longestCount = Math.max(longestCount, currCount);
            }
        }

        return longestCount;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
