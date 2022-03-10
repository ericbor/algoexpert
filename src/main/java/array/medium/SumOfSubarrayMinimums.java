package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/sum-of-subarray-minimums/
public class SumOfSubarrayMinimums {
    public int sumSubarrayMins_2(int[] arr) {
        int mod = 1_000_000_007;

        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);

                result = (result + min) % mod;
            }
        }

        return result;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];

        Deque<int[]> s1 = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > arr[i]) {
                count += s1.pop()[1];
            }
            s1.push(new int[] {arr[i], count});
            left[i] = count;
        }

        int[] right = new int[n];
        Deque<int[]> s2 = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= arr[i]) {
                count += s2.pop()[1];
            }
            s2.push(new int[] {arr[i], count});
            right[i] = count;
        }

        int res = 0;
        int mod = 1_000_000_007;
        for (int i = 0; i < n; ++i) {
            res = (res + arr[i] * left[i] * right[i]) % mod;
        }

        return (int)res;
    }

    @Test
    public void test() {
        Assert.assertEquals(17, sumSubarrayMins(new int[] { 3, 1, 2, 4 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(444, sumSubarrayMins(new int[] { 11, 81, 94, 43, 3 }));
    }
}
