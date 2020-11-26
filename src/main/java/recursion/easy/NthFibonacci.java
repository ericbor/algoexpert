package recursion.easy;

import org.junit.Assert;
import org.junit.Test;

public class NthFibonacci {
    public static int getNthFib(int n) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }

        return getNthFib(n - 1) + getNthFib(n - 2);
    }

    @Test
    public void verify() {
        Assert.assertEquals(34, getNthFib(10));
    }
}
