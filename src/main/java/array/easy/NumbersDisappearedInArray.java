package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class NumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int[] numsCounter = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int index = nums[i]-1;
            numsCounter[index]++;
        }

        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < numsCounter.length; i++) {
            if(numsCounter[i] == 0) {
                results.add(i+1);
            }
        }

        return results;
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(5,6), findDisappearedNumbers(new int[] { 4,3,2,7,8,2,3,1 }));
    }
}
