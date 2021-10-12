package educative.topkelements.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array. Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.

Input: [5, 6, 7, 8, 9], K = 3, X = 7
Output: [6, 7, 8]

Input: [2, 4, 5, 6, 9], K = 3, X = 6
Output: [4, 5, 6]
 */
public class KClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {

        Map<Integer, Integer> closestMap = new HashMap<>();
        for (int num : arr) {
            closestMap.put(num, Math.abs(X - num));
        }

        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        for (Map.Entry<Integer, Integer> entry : closestMap.entrySet()) {
            maxHeap.add(entry);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }

    @Test
    public void main() {
        Assert.assertEquals(List.of(6, 8, 7), findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7));
    }

    @Test
    public void main2() {
        Assert.assertEquals(List.of(4, 5, 6), findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6));
    }

    @Test
    public void main3() {
        Assert.assertEquals(List.of(5, 6, 9), findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10));
    }
}

/*class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}*/
