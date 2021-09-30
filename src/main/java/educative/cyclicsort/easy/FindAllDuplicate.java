package educative.cyclicsort.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
The array has some numbers appearing twice, find all these duplicate numbers without using any extra space.

Input: [3, 4, 4, 5, 5] ... Output: [4, 5]

Input: [5, 4, 7, 2, 3, 5, 3] ... Output: [3, 5]
 */
public class FindAllDuplicate {
    public static List<Integer> findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int currVal = nums[i];
            if (nums[i] != nums[currVal - 1]) {
                swap(nums, i, currVal - 1);
            } else {
                i++;
            }
        }
        List<Integer> duplicateNumbers = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                duplicateNumbers.add(nums[k]);
            }
        }

        return duplicateNumbers;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(5, 4), findNumbers(new int[] { 3, 4, 4, 5, 5 }));
        Assert.assertEquals(List.of(3, 5), findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 }));
    }
}
