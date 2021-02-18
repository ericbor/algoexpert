package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/rank-transform-of-an-array/
public class RankTransformOfArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArray = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArray);

        Map<Integer, Integer> rankMap = new HashMap<>();

        for (int value : sortedArray) {
            rankMap.putIfAbsent(value, rankMap.size() + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { 4, 1, 2, 3 }, arrayRankTransform(new int[] { 40, 10, 20, 30 }));
        Assert.assertArrayEquals(new int[] { 1, 1, 1 }, arrayRankTransform(new int[] { 100, 100, 100 }));
    }
}
