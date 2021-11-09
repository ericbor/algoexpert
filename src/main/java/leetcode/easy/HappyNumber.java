package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/happy-number/
public class HappyNumber {
    public boolean isHappy2(int n) {

        Set<Integer> set = new HashSet<>();

        while (n > 1) {
            n = getNext(n);

            if (!set.add(n)) {
                return false;
            }
        }

        return true;
    }

    public boolean isHappy(int n) {

        int slow = n;
        int fast = n;
        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int reminder = n % 10;
            totalSum += reminder * reminder;

            n /= 10;
        }

        return totalSum;
    }

    @Test
    public void test() {
        Assert.assertTrue(isHappy(188));
    }

    @Test
    public void test2() {
        Assert.assertTrue(isHappy(109));
    }

    @Test
    public void test3() {
        Assert.assertTrue(isHappy(19));
    }

    @Test
    public void test4() {
        Assert.assertFalse(isHappy(2));
    }

    @Test
    public void test5() {
        Assert.assertTrue(isHappy(7));
    }
}
