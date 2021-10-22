package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/find-the-highest-altitude/
public class FindHighestAltitude {
    public int largestAltitude(int[] gains) {
        int highest = 0;

        int result = 0;
        for (int gain : gains) {
            highest += gain;
            result = Math.max(result, highest);

        }

        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(781, largestAltitude(new int[] { 44, 32, -9, 52, 23, -50, 50, 33, -84, 47, -14, 84, 36, -62, 37, 81, -36, -85, -39, 67, -63, 64, -47, 95, 91, -40, 65, 67, 92, -28, 97, 100, 81 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, largestAltitude(new int[] { -5, 1, 5, 0, -7 }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, largestAltitude(new int[] { -4, -3, -2, -1, 4, 3, 2 }));
    }
}
