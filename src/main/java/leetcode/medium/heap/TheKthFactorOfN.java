package leetcode.medium.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/the-kth-factor-of-n/
public class TheKthFactorOfN {
    // O(N), O(1)
    public int kthFactor2(int n, int k) {
        if (k > n) {
            return -1;
        }

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                k--;

                if (k == 0) {
                    return i;
                }
            }
        }

        return -1;
    }

    // max heap -> to keep max element always on top
    private final Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    // push into heap by limiting size of heap to k
    private void push(int value, int limit) {
        maxHeap.add(value);
        if (maxHeap.size() > limit) {
            maxHeap.poll();
        }
    }

    // O(sqrt(N) log K), O(min(K, sqrt(N)))
    public int kthFactor(int n, int k) {
        int sqrtN = (int) Math.sqrt(n);

        for (int i = 1; i <= sqrtN; i++) {
            if (n % i == 0) {
                push(i, k);

                int pair = n / i;
                if (i != pair) {
                    push(pair, k);
                }
            }
        }

        return k == maxHeap.size() ? maxHeap.poll() : -1;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, kthFactor(12, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(7, kthFactor(7, 2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-1, kthFactor(4, 4));
    }
}
