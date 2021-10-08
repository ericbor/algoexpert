package educative.subsets.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of numbers that might contain duplicates, find all of its distinct subsets.

Input: [1, 5, 3, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
 */
public class SubsetWithDuplicates {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(num);
                if (!subsets.contains(set)) {
                    subsets.add(set);
                }
            }
        }
        return subsets;
    }

    public static List<List<Integer>> findSubsets2(int[] nums) {
        // sort the numbers to handle duplicates
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        int endIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int startIndex = 0;
            // if current and the previous elements are same, create new subsets only from the subsets added in the previous step
            if (i > 0 && nums[i] == nums[i - 1]) {
                startIndex = endIndex + 1;
            }
            endIndex = subsets.size() - 1;
            for (int j = startIndex; j <= endIndex; j++) {
                // create a new subset from the existing subset and add the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }

        return subsets;
    }

    @Test
    public void main() {
        List<List<Integer>> result = findSubsets(new int[] { 1, 5, 3, 3 });
        Assert.assertEquals(List.of(
            List.of(),
            List.of(1),
            List.of(5),
            List.of(1, 5),
            List.of(3),
            List.of(1, 3),
            List.of(5, 3),
            List.of(1, 5, 3),
            List.of(3, 3),
            List.of(1, 3, 3),
            List.of(5, 3, 3),
            List.of(1, 5, 3, 3)), result);

        List<List<Integer>> result2 = findSubsets2(new int[] { 1, 5, 3, 3 });
        Assert.assertEquals(List.of(
            List.of(),
            List.of(1),
            List.of(3),
            List.of(1, 3),
            List.of(3, 3),
            List.of(1, 3, 3),
            List.of(5),
            List.of(1, 5),
            List.of(3, 5),
            List.of(1, 3, 5),
            List.of(3, 3, 5),
            List.of(1, 3, 3, 5)), result2);
    }
}
