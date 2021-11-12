package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/count-largest-group/
public class CountLargestGroup {
    public int countLargestGroup(int n) {
        int[] freq = new int [37];
        int largest = 0;

        for(int i = 1; i <= n; i++) {
            if(i < 10) {
                freq[i]++;

                largest = Math.max(largest, freq[i]);
            } else {
                int index = getIndex(i);
                freq[index]++;

                largest = Math.max(largest, freq[index]);
            }
        }

        int countLargest = 0;
        for(int num: freq) {
            if(num == largest) {
                countLargest++;
            }
        }

        return countLargest;
    }

    private int getIndex(int n) {
        int sum = 0;
        while(n > 0) {
            int reminder = n % 10;
            sum += reminder;
            n /= 10;
        }

        return sum;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, countLargestGroup(13));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, countLargestGroup(2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(6, countLargestGroup(15));
    }

    @Test
    public void test4() {
        Assert.assertEquals(5, countLargestGroup(24));
    }

    @Test
    public void test5() {
        Assert.assertEquals(1, countLargestGroup(9999));
    }
}
