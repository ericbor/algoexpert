package other.easy;

import org.junit.Assert;
import org.junit.Test;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {

        int sol = 0;
        int expOfFive = 5;
        while(n >= expOfFive){
            sol += n / expOfFive;
            expOfFive = 5 * expOfFive;
        }
        return sol;
    }

    @Test
    public void verify() {
        Assert.assertEquals(7, trailingZeroes(30));
    }
}
