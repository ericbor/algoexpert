package leetcode.easy.mergeintervals;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/teemo-attacking/
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        if (timeSeries.length == 0) {
            return 0;
        }

        int seconds = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int currDuration = timeSeries[i + 1] - timeSeries[i];

            seconds += Math.min(currDuration, duration);
        }

        return seconds + duration;
    }

    @Test
    public void test() {
        Assert.assertEquals(9, findPoisonedDuration(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, findPoisonedDuration(new int[] { 1, 4 }, 2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, findPoisonedDuration(new int[] { 1, 2 }, 2));
    }
}
