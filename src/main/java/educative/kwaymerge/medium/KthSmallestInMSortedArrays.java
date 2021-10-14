package educative.kwaymerge.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.

Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
Output: 4
Explanation: The 5th smallest number among all the arrays is 4, this can be verified from
the merged list of all the arrays: [1, 2, 3, 3, 4, 6, 6, 7, 8]
 */
public class KthSmallestInMSortedArrays {
    public static int findKthSmallest(List<Integer[]> lists, int k) {
        Queue<Integer[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (Integer[] list : lists) {
            minHeap.add(list);
        }

        LinkedList<Integer> result = new LinkedList<>();
        //int kthSmallest = -1;

        while (!minHeap.isEmpty() && k > 0) {
            Integer[] curr = minHeap.poll();
            result.add(curr[0]);
            k--;

            if (curr.length > 1) {
                Integer[] nextCurr = new Integer[curr.length - 1];
                for (int i = 1; i < curr.length; i++) {
                    nextCurr[i - 1] = curr[i];
                }
                minHeap.add(nextCurr);
            }
        }

        return result.getLast();
    }

    @Test
    public void main() {
        Integer[] l1 = { 2, 6, 8 };
        Integer[] l2 = { 3, 6, 7 };
        Integer[] l3 = { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        Assert.assertEquals(4, findKthSmallest(lists, 5));
    }

    @Test
    public void main2() {
        Integer[] l1 = { 5, 8, 9 };
        Integer[] l2 = { 1, 7 };
        List<Integer[]> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        Assert.assertEquals(7, findKthSmallest(lists, 3));
    }
}
