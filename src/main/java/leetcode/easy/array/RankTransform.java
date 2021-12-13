package leetcode.easy.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/rank-transform-of-an-array/
public class RankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();

        for (int j : temp) {
            map.putIfAbsent(j, map.size() + 1);
        }

        for (int i = 0; i < temp.length; i++) {
            temp[i] = map.get(arr[i]);
        }
        return temp;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 5, 3, 4, 2, 8, 6, 7, 1, 3 }, arrayRankTransform(new int[] { 37, 12, 28, 9, 100, 56, 80, 5, 12 }));
    }
}
