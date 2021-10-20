package educative.slidingwindow.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/sum-of-all-odd-length-subarrays/submissions/
public class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        if (arr.length < 3) {
            return sum;
        }
        if (arr.length == 3) {
            return sum + sum;
        }

        Set<Integer> odds = new HashSet<>();
        int n = arr.length;
        while (n >= 3) {
            if (n % 2 == 0) {
                n--;
                odds.add(n);
            } else {
                odds.add(n);
                n -= 2;
            }
        }

        for (int odd : odds) {
            int currentSum = 0;
            int windowStart = 0;
            for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
                currentSum += arr[windowEnd];

                if (windowEnd >= odd - 1) {
                    sum += currentSum;

                    currentSum -= arr[windowStart];
                    windowStart++;
                }
            }
        }

        return sum;
    }


    @Test
    public void test() {
        Assert.assertEquals(58, sumOddLengthSubarrays(new int[] { 1, 4, 2, 5, 3 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, sumOddLengthSubarrays(new int[] { 1, 2 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(66, sumOddLengthSubarrays(new int[] { 10, 11, 12 }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(68, sumOddLengthSubarrays(new int[] { 7, 6, 8, 6 }));
    }
}
