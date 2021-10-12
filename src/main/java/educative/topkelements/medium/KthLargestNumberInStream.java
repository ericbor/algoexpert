package educative.topkelements.medium;

import java.util.PriorityQueue;
import java.util.Queue;

/*
Design a class to efficiently find the Kth largest element in a stream of numbers.
The class should have the following two things:

- The constructor of the class should accept an integer array containing initial numbers from the stream and an integer ‘K’.
- The class should expose a function add(int num) which will store the given number and return the Kth largest number.

Input: [3, 1, 5, 12, 2, 11], K = 4
1. Calling add(6) should return '5'.
2. Calling add(13) should return '6'.
2. Calling add(4) should still return '6'.
 */
public class KthLargestNumberInStream {
    private Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
    private int k;

    /*public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int num) {
        if (minHeap.peek() < num) {
            minHeap.poll();
            minHeap.add(num);
        }

        return minHeap.peek();
    }*/

    public KthLargestNumberInStream(int[] nums, int k) {
        this.k = k;
        // add the numbers in the min heap
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int num) {
        // add the new number in the min heap
        minHeap.add(num);

        // if heap has more than 'k' numbers, remove one number
        if (minHeap.size() > this.k) {
            minHeap.poll();
        }

        // return the 'Kth largest number
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestNumberInStream cl = new KthLargestNumberInStream(new int[] { 3, 1, 5, 12, 2, 11 }, 4);
        System.out.println("*: " + cl.add(6));
        System.out.println("*: " + cl.add(13));
        System.out.println("*: " + cl.add(4));
    }
}
