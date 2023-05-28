package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/h-index
public class HIndex {
    public int hIndex(int[] citations) {
        // sorting the citations in ascending order
        Arrays.sort(citations);
        // finding h-index by linear search
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i; // after the while loop, i = i' + 1
    }

    @Test
    public void test() {
        Assert.assertEquals(3, hIndex(new int[]{3,0,6,1,5}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, hIndex(new int[]{1,3,1}));
    }
}
