import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/interval-list-intersections
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int a = 0;
        int b = 0;

        while (a < firstList.length && b < secondList.length) {
            int low = Math.max(firstList[a][0], secondList[b][0]);
            int high = Math.min(firstList[a][1], secondList[b][1]);

            if (low <= high) {
                list.add(new int[]{low, high});
            }

            if (firstList[a][1] < secondList[b][1]) {
                a++;
            } else {
                b++;
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }


    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}},
                intervalIntersection(
                        new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                        new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}));
    }
}
