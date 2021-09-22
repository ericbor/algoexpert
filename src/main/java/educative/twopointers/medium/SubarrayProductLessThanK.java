package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given an array with positive numbers and a positive target number, find all of its CONTIGUOUS subarrays whose product is less than the target number.

Input: [2, 5, 3, 10], target=30 ... Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.

Input: [8, 2, 6, 5], target=50 ... Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
Explanation: There are seven contiguous subarrays whose product is less than the target.
 */
public class SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();

        double product = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];//1*8=8, 8*2=16, 16*6=96, 12*5=60

            while (product >= target && left < arr.length) { //96 >= 50, 60 >= 50
                product /= arr[left];// 96/8=12, 60/2=30
                left++;//left=1, left=2
            }
            // since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from left to right will have a product less than the target too; to avoid
            // duplicates, we will start with a subarray containing only arr[right] and then extend it
            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }

        return result;
    }

    @Test
    public void verify() {
        //Assert.assertEquals(List.of(List.of(2), List.of(5), List.of(2, 5), List.of(3), List.of(5, 3), List.of(10)), findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        Assert.assertEquals(List.of(List.of(8), List.of(2), List.of(8, 2), List.of(6), List.of(2, 6), List.of(5), List.of(6, 5)), findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
