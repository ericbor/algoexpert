package educative.topkelements.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
The cost of connecting two ropes is equal to the sum of their lengths.

Input: [1, 3, 11, 5] ... Output: 33
Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)

Input: [3, 4, 5, 6] ... Output: 36
Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)
 */
public class ConnectRopes {
    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int num : ropeLengths) {
            minHeap.add(num);
        }

        int sum = 0;
        while (minHeap.size() > 1) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            int result = a + b;
            minHeap.add(result);
            sum += result;
        }

        return sum;
    }

    @Test
    public void main() {
        Assert.assertEquals(33, minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 }));
    }

    @Test
    public void main2() {
        Assert.assertEquals(36, minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 }));
    }

    @Test
    public void main3() {
        Assert.assertEquals(42, minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 }));
    }
}
