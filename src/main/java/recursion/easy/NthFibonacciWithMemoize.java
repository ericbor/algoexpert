package recursion.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacciWithMemoize {
    public static int getNthFib(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);

        return getNthFib(n, memoize);
    }

    public static int getNthFib(int n, Map<Integer, Integer> memoize) {
        if (memoize.get(n) != null) {
            return memoize.get(n);
        }

        memoize.put(n, getNthFib(n - 1, memoize) + getNthFib(n - 2, memoize));
        return memoize.get(n);
    }

    @Test
    public void verify() {
        Assert.assertEquals(34, getNthFib(10));
    }
}
