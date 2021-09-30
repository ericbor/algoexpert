package educative.cyclicsort.easy;

/*
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
The array originally contained all the numbers from 1 to ‘n’, but due to a data error,
one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.

Input: [3, 1, 2, 5, 2] ... Output: [2, 4]
Explanation: '2' is duplicated and '4' is missing.
 */
public class FindCorruptNums {
    public static int[] findNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int currVal = nums[i];
            if (currVal != nums[currVal - 1]) {
                swap(nums, i, currVal - 1);
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                return new int[] { nums[k], k + 1 };
            }
        }

        return new int[] { -1, -1 };
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
