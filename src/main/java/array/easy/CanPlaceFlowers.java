package array.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/can-place-flowers
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        int zeroCount = 0;

        while(i < flowerbed.length){
            if(flowerbed[i] == 0){
                if(i == 0 || flowerbed[i-1] == 0){
                    if(i == flowerbed.length - 1 || flowerbed[i + 1] == 0){
                        flowerbed[i] = 1;
                        zeroCount++;
                    }
                }
            }
            i++;
        }

        return zeroCount >=n;
    }

    @Test
    public void verify() {
        Assert.assertTrue(canPlaceFlowers(new int[] { 1,0,0,0,1 }, 1));
        Assert.assertFalse(canPlaceFlowers(new int[] { 1,0,0,0,1 }, 2));
    }
}
