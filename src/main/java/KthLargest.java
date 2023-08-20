import org.junit.Assert;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
public class KthLargest {
    private int kth;
    private Queue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        this.minHeap = new PriorityQueue<>();

        for(int num: nums) {
            minHeap.add(num);

            if(minHeap.size() > kth) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);

        if(minHeap.size() > kth) {
            minHeap.poll();
        }


        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest kL = new KthLargest(3, new int[]{4, 5, 8, 2});
        Assert.assertEquals(4, kL.add(3));
        Assert.assertEquals(5, kL.add(5));
        Assert.assertEquals(5, kL.add(10));
        Assert.assertEquals(8, kL.add(9));
        Assert.assertEquals(8, kL.add(4));
    }
}
