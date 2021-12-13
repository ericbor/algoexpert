package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/plus-one/
public class PlusOne {
    public int[] plusOne2(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] += 1;

            return digits;
        }

        boolean isAllNines = allNines(digits);
        if (!isAllNines) {
            int[] result = new int[digits.length];
            result[result.length - 1] = 0;
            boolean handled = false;

            for (int i = digits.length - 2; i >= 0; i--) {
                if (handled) {
                    result[i] = digits[i];
                } else if (digits[i] == 9) {
                    result[i] = 0;
                } else {
                    result[i] = digits[i] + 1;
                    handled = true;
                }
            }

            return result;
        }

        int[] result = new int[digits.length + 1];
        result[result.length - 1] = 0;

        boolean handled = false;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (handled) {
                result[i + 1] = digits[i];
            } else if (digits[i] == 9) {
                result[i + 1] = 0;
            } else {
                result[i + 1] = digits[i] + 1;
                handled = true;
            }
        }

        result[0] = 1;

        return result;
    }

    private boolean allNines(int[] arr) {
        for (int num : arr) {
            if (num != 9) {
                return false;
            }
        }

        return true;
    }

    public int[] plusOne(int[] digits) {

        // move along the input array starting from the end
        for (int i = digits.length - 1; i >= 0; --i) {
            // set all the nines at the end of array to zeros
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {  // here we have the rightmost not-nine
                // increase this rightmost not-nine by 1
                digits[i]++;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 1, 0, 0 }, plusOne(new int[] { 9, 9 }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[] { 9, 0 }, plusOne(new int[] { 8, 9 }));
    }
}
