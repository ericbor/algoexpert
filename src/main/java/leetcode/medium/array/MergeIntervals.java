package leetcode.medium.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

//https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        LinkedList<int[]> nonOverlappingList = new LinkedList<>();
        nonOverlappingList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (nonOverlappingList.getLast()[1] >= curr[0]) {
                nonOverlappingList.getLast()[1] = Math.max(curr[1], nonOverlappingList.getLast()[1]);
            } else {
                nonOverlappingList.add(curr);
            }
        }

        if (nonOverlappingList.size() == intervals.length) {
            return intervals;
        }

        return nonOverlappingList.toArray(new int[nonOverlappingList.size()][]);
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][] { { 1, 3 }, { 4, 7 } }, merge(new int[][] { { 2, 3 }, { 2, 2 }, { 3, 3 }, { 1, 3 }, { 5, 7 }, { 2, 2 }, { 4, 6 } }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } }, merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new int[][] { { 1, 5 } }, merge(new int[][] { { 1, 4 }, { 4, 5 } }));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new int[][] { { 1, 4 } }, merge(new int[][] { { 1, 4 }, { 2, 3 } }));
    }
}
