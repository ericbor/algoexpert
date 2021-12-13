package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; ++i) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;//prev number is duplicate, skip
            }

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    triplets.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    end--;
                    start++;

                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                }
            }

        }

        return triplets;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, triplets);
            }
        }
        return triplets;
    }
    void twoSum(int[] nums, int i, List<List<Integer>> triplets) {
        Set<Integer> seen = new HashSet<>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];

            if (seen.contains(complement)) {
                triplets.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }
            seen.add(nums[j]);
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of(-2, 0, 2)), threeSum(new int[] { -2, 0, 0, 2, 2 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)), threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(List.of(List.of(-2, -1, 3), List.of(-2, 0, 2), List.of(-1, 0, 1)), threeSum(new int[] { 3, 0, -2, -1, 1, 2 }));
    }
}
