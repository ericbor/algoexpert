package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fibonacci-number
public class Fibonacci {

    private final Map<Integer, Integer> cache = new HashMap<>(Map.of(0, 0, 1, 1));

    // O(2^N), O(N)
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    // O(N), O(N)
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }

        int[] cache = new int[N + 1];
        cache[1] = 1;
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[N];
    }

    // O(N), O(N)
    public int fib3(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }

        cache.put(N, fib3(N - 1) + fib3(N - 2));
        return cache.get(N);
    }

    // O(N), O(1)
    public int fib4(int N) {
        if( N <= 1) {
            return N;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 0;

        for(int i = 2; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    @Test
    public void test() {
        Assert.assertEquals(21, fib(8));
    }

    @Test
    public void test2() {
        Assert.assertEquals(21, fib2(8));
    }

    @Test
    public void test3() {
        Assert.assertEquals(21, fib3(8));
    }

    @Test
    public void test4() {
        Assert.assertEquals(21, fib4(8));
    }
}
