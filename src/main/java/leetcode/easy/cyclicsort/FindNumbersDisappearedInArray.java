package leetcode.easy.cyclicsort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if(nums[index] > 0) {
                nums[index] *= -1;
            }
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                results.add(i + 1);
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(5, 6), findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
