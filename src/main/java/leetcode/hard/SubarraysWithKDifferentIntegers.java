package leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int counter = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        while (end < nums.length && start < nums.length) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            while (map.size() > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) <= 0) {
                    map.remove(nums[start]);
                }
                start++;
            }

            int prev = start;
            while (start <= end && map.size() == k) { //start==end incase of K=1
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) <= 0) {
                    map.remove(nums[start]);
                }
                start++;
                counter++;
            }

            while (prev != start) {
                start--;
                map.put(nums[start], map.getOrDefault(nums[start], 0) + 1);
                // now get back to the state you previously were
            }
            end++;

        }

        return counter;
    }

    @Test
    public void test() {
        Assert.assertEquals(7, subarraysWithKDistinct(new int[] { 1, 2, 1, 2, 3 }, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, subarraysWithKDistinct(new int[] { 1, 2, 1, 3, 4 }, 3));
    }
}
