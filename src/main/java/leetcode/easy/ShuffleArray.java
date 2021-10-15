package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/shuffle-the-array/
public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        int numsIdx = 0;
        int resultIdx = 0;
        while(resultIdx < result.length){
            result[resultIdx] = nums[numsIdx];
            result[resultIdx + 1] = nums[numsIdx + n];
            numsIdx++;
            resultIdx +=2;
        }

        return result;
    }

    public int[] shuffle2(int[] nums, int n) {

        for(int i=1; i<n; i++) {
            for(int j=i, k=n; j<n; j++,k++) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
            }
        }
        return nums;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{2,3,5,4,1,7}, shuffle2(new int[]{2,5,1,3,4,7}, 3));
    }
}
