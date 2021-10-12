package educative.xor.easy;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of n-1n−1 integers in the range from 11 to nn, find the one number that is missing from the array.

Input: 1, 5, 2, 6, 4
Answer: 3
 */
public class FindMissingNumber {

    //possible integer overflow, when `n` is large
    public static int findMissingNumber2(int[] arr) {
        int n = arr.length + 1;
        // find sum of all numbers from 1 to n.
        int s1 = 0;
        for (int i = 1; i <= n; i++) {
            s1 += i;
        }

        // subtract all numbers in input from sum.
        for (int num : arr) {
            s1 -= num;
        }

        // s1, now, is the missing number
        return s1;
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        // find sum of all numbers from 1 to n.
        int x1 = 0;
        for (int i = 1; i <= n; i++) {
            x1 = x1 ^ i;
        }

        // x2 represents XOR of all values in arr
        int x2 = arr[0];
        for (int i = 1; i < n-1; i++) {
            x2 = x2 ^ arr[i];
        }

        // missing number is the xor of x1 and x2
        return x1 ^ x2;
    }

    @Test
    public void verify(){
        Assert.assertEquals(3, findMissingNumber(new int[] { 1, 5, 2, 6, 4 }));
    }
}
