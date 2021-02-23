package other.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/happy-number/
public class HappyNumber {
    //Time: O(log n), Space: O(log n)
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    public boolean isHappy2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while(fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }

        return fastRunner == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int reminder = n % 10;
            n = n / 10;
            totalSum = totalSum + (reminder * reminder);
        }

        return totalSum;
    }

    @Test
    public void verify() {
        Assert.assertTrue(isHappy(19));
        Assert.assertFalse(isHappy(2));
        Assert.assertTrue(isHappy2(19));
        Assert.assertFalse(isHappy2(2));
    }
}
