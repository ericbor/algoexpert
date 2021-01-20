package string.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/majority-element
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> storage = new HashMap<>();
        for (int i : nums) {
            if (storage.containsKey(i)) {
                storage.put(i, storage.get(i) + 1);
            } else {
                storage.put(i, 1);
            }
        }

        return storage.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

    public int majorityElementSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    @Test
    public void verify() {
        Assert.assertEquals(2, majorityElementSorting(new int[] { 2,2,1,1,1,2,2 }));
    }
}
