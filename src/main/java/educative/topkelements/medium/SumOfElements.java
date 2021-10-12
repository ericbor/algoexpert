package educative.topkelements.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.

Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
Output: 23
Explanation: The 3rd smallest number is 5 and 6th - 15. The sum of numbers coming between 5 and 15 is 23 (11+12).

Input: [3, 5, 8, 7], and K1=1, K2=4
Output: 12
Explanation:  the 1st smallest number (3) and the 4th smallest number (8), the sume is is 12 (5+7).
 */
public class SumOfElements {
    public static int findSumOfElements(int[] nums, int k1, int k2) {
        int total = k2 - k1;
        Queue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
        for(int num: nums) {
            minHeap.add(num);
            if(minHeap.size() > total){
                minHeap.poll();
            }
        }

        int sum = 0;
        while (minHeap.size() > 1){
            sum += minHeap.poll();
        }

        return sum;
    }

    @Test
    public void main() {
        Assert.assertEquals(23, findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6));
    }

    @Test
    public void main2() {
        Assert.assertEquals(12, findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4));
    }
}
