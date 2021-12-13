package leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/summary-ranges/
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            int i = j;
            // try to extend the range [nums[i], nums[j]]
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                ++j;
            }
            // put the range into the list
            if (i == j) {
                summary.add(nums[i] + "");
            } else {
                summary.add(nums[i] + "->" + nums[j]);
            }
        }
        return summary;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("0", "2->4", "6", "8->9"), summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }));
    }
}
