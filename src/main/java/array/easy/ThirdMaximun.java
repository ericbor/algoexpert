package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/third-maximum-number
public class ThirdMaximun {
    public int thirdMax(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        for (int num : nums) {
            setNums.add(num);
        }

        int max = Collections.max(setNums);

        if (setNums.size() < 3) {
            return max;
        }

        setNums.remove(max);
        int seconfMax = Collections.max(setNums);
        setNums.remove(seconfMax);

        return Collections.max(setNums);
    }

    public int thirdMax2(int[] nums) {
        Set<Integer> maximums = new HashSet<>();
        for (int num : nums) {
            maximums.add(num);
            if (maximums.size() > 3) {
                maximums.remove(Collections.min(maximums));
            }
        }
        if (maximums.size() == 3) {
            return Collections.min(maximums);
        }

        return Collections.max(maximums);
    }

    @Test
    public void verify() {
        Assert.assertEquals(1, thirdMax(new int[] { 3, 2, 1 }));
        Assert.assertEquals(2, thirdMax(new int[] { 1, 2 }));
        Assert.assertEquals(1, thirdMax(new int[] { 2, 2, 3, 1 }));

        Assert.assertEquals(1, thirdMax2(new int[] { 3, 2, 1 }));
        Assert.assertEquals(2, thirdMax2(new int[] { 1, 2 }));
        Assert.assertEquals(1, thirdMax2(new int[] { 2, 2, 3, 1 }));
    }
}
