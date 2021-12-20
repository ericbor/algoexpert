package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
public class MinSwapsToGroupAllOnes {
    //O(N), O(1)
    public int minSwaps(int[] data) {
        int totalOnes = 0;
        for (int num : data) {
            if (num == 1) {
                totalOnes++;
            }
        }

        int start = 0;
        int maxOnesInWindow = 0;
        int currOnesInWindow = 0;
        for (int end = 0; end < data.length; end++) {
            if (data[end] == 1) {
                currOnesInWindow++;
            }

            if (end - start >= totalOnes) {
                if (data[start] == 1) {
                    currOnesInWindow--;
                }
                start++;
            }

            maxOnesInWindow = Math.max(maxOnesInWindow, currOnesInWindow);
        }

        return totalOnes - maxOnesInWindow;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, minSwaps(new int[] { 1, 0, 1, 0, 0, 1, 0, 1, 1 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, minSwaps(new int[] { 1, 0, 1, 0, 1 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, minSwaps(new int[] { 0, 0, 0, 1, 0 }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(8, minSwaps(new int[] { 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1 }));
    }

    @Test
    public void test5() {
        Assert.assertEquals(3, minSwaps(new int[] { 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1 }));
    }

}
