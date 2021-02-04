package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/maximum-units-on-a-truck/
public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int unitsLoaded = 0;
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int numberOfUnits = boxType[1];

            //how many boxes we can fit
            int maxBoxCount = Math.min(truckSize, numberOfBoxes);
            unitsLoaded += maxBoxCount * numberOfUnits;

            truckSize -= maxBoxCount;
            if (truckSize == 0) {
                break;
            }
        }

        return unitsLoaded;
    }

    public int maximumUnits2(int[][] boxTypes, int truckSize) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        queue.addAll(Arrays.asList(boxTypes));

        int unitsLoaded = 0;
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int numberOfBoxes = top[0];
            int numberOfUnits = top[1];

            int maxBoxCount = Math.min(truckSize, numberOfBoxes);
            unitsLoaded += maxBoxCount * numberOfUnits;

            truckSize -= maxBoxCount;
            if (truckSize == 0) {
                break;
            }
        }

        return unitsLoaded;
    }

    @Test
    public void verify() {
        //Assert.assertEquals(8, maximumUnits(new int[][] { { 1, 3 }, { 2, 2 }, { 3, 1 } }, 4));
        Assert.assertEquals(91, maximumUnits(new int[][] { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } }, 10));
    }
}
