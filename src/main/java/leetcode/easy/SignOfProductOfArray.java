package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/sign-of-the-product-of-an-array/
public class SignOfProductOfArray {
    public int arraySign(int[] nums) {

        int result = 1;

        for(int num: nums) {
            if(num == 0) {
                return 0;
            }

            if(result * num > 0) {
                result = 1;
            } else {
                result = -1;
            }
        }

        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(-1, arraySign(new int[]{9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, arraySign(new int[]{1,5,0,2,-3}));
    }
}
