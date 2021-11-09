package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/relative-sort-array/
public class RelativeSortArray {
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int[] results = new int[arr1.length];
        int nextIndex = 0;
        for (int num : arr2) {
            int frequency = freqMap.get(num);

            for (int i = nextIndex; i < nextIndex + frequency; i++) {
                results[i] = num;
            }
            nextIndex += frequency;

            freqMap.remove(num);
        }

        Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getKey() - e2.getKey());
        minHeap.addAll(freqMap.entrySet());

        while(!minHeap.isEmpty()) {
            int value = minHeap.peek().getKey();
            int frequency = minHeap.poll().getValue();

            for (int i = nextIndex; i < nextIndex + frequency; i++) {
                results[i] = value;
            }
            nextIndex += frequency;
        }

        return results;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Bucket for 0 <= arr element <= 1000
        int[] bucket = new int[1001];

        int[] result = new int[arr1.length];
        int index = 0;

        // Fill bucket
        for(int i : arr1) {
            bucket[i]++;
        }

        // First store result in order of arr2
        for(int i : arr2) {
            while(bucket[i] > 0) {
                result[index] = i;

                index++;
                bucket[i]--;
            }
        }

        // Fill remaining element
        for(int i = 0; i < 1001; i++){
            if(bucket[i] > 0) {
                while(bucket[i] > 0) {
                    result[index] = i;

                    index++;
                    bucket[i]--;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 2, 42, 38, 0, 43, 21, 5, 7, 12, 12, 13, 23, 24, 24, 27, 29, 30, 31, 33, 48 }, relativeSortArray(new int[] { 2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31 }, new int[] { 2, 42, 38, 0, 43, 21 }));
        Assert.assertArrayEquals(new int[] { 2, 42, 38, 0, 43, 21, 5, 7, 12, 12, 13, 23, 24, 24, 27, 29, 30, 31, 33, 48 }, relativeSortArray2(new int[] { 2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31 }, new int[] { 2, 42, 38, 0, 43, 21 }));

    }
}
