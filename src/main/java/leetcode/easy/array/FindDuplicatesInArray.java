package leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindDuplicatesInArray {
    public List<Integer> findDuplicates2(int[] nums) {
        int[] freq = new int[100001];
        List<Integer> results = new ArrayList<>();
        for (int num : nums) {
            freq[num]++;
            if (freq[num] > 1) {
                results.add(num);
            }
        }

        return results;
    }

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> results = new ArrayList<>();

        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) { // seen before
                results.add(Math.abs(num));
            }
            nums[idx] *= -1;
        }

        return results;
    }

    @Test
    public void test() {
        List<Integer> results = findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 });
        Assert.assertEquals(2, results.size());
        Assert.assertTrue(results.contains(2));
        Assert.assertTrue(results.contains(3));
    }
}
