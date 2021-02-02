package bit.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/explore/featured/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3625/
public class NumberOf1bits {
    public int hammingWeight(long n) {
        int counter = 0;
        for(int i = 0; i < 32; i++) {
            if((n >>> i) % 2 == 1) {
                counter++;
            }
        }

        return counter;
    }

    @Test
    public void verify() {
        //Assert.assertEquals(31, hammingWeight(11111111111111111111111111111101));
    }
}
