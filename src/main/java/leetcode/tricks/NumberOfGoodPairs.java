package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/number-of-good-pairs/
/*
Can be represented as number of unique Handshakes between group of people.
Same number - possible handshake:
[1,1,1,1] - 4 people can have a total of 6 unique handshakes: 3 + 2 + 1 = 6
N*(N-1)/2
4*(4-1)/2 = 4*3/2 = 12/2 = 6
 */
public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        for (int i = 0; i < nums.length - 1; i++){
            for(int k = i + 1; k < nums.length; k++){
                if(nums[i] == nums[k]){
                    goodPairs++;
                }
            }
        }

        return goodPairs;
    }

    public int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num: nums){
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0) + 1);
        }

        int goodPairsTotal = 0;
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()){
            int frequency = entry.getValue();
            int goodPairs = frequency * (frequency - 1) / 2;
            goodPairsTotal += goodPairs;
        }

        return goodPairsTotal;
    }

    public int numIdenticalPairs3(int[] nums) {
        int[] frequencies = new int[101];
        for(int num: nums){
            frequencies[num]++;
        }

        int goodPairsTotal = 0;
        for(int frequency : frequencies){
            int goodPairs = frequency * (frequency - 1) / 2;
            goodPairsTotal += goodPairs;
        }

        return goodPairsTotal;
    }

    public int numIdenticalPairs4(int[] nums) {
        int goodPairsTotal = 0;
        int[] frequencies = new int[101];
        for(int num: nums){
            goodPairsTotal += frequencies[num];
            frequencies[num]++;
        }

        return goodPairsTotal;
    }

    @Test
    public void test(){
        Assert.assertEquals(4, numIdenticalPairs(new int[]{1,2,3,1,1,3}));
        Assert.assertEquals(6, numIdenticalPairs(new int[]{1,1,1,1}));
        Assert.assertEquals(0, numIdenticalPairs(new int[]{1,2,3}));
    }

    @Test
    public void test2(){
        Assert.assertEquals(4, numIdenticalPairs2(new int[]{1,2,3,1,1,3}));
        Assert.assertEquals(6, numIdenticalPairs2(new int[]{1,1,1,1}));
        Assert.assertEquals(0, numIdenticalPairs2(new int[]{1,2,3}));
    }

    @Test
    public void test3(){
        Assert.assertEquals(4, numIdenticalPairs3(new int[]{1,2,3,1,1,3}));
        Assert.assertEquals(6, numIdenticalPairs3(new int[]{1,1,1,1}));
        Assert.assertEquals(0, numIdenticalPairs3(new int[]{1,2,3}));
    }

    @Test
    public void test4(){
        Assert.assertEquals(4, numIdenticalPairs4(new int[]{1,2,3,1,1,3}));
        Assert.assertEquals(6, numIdenticalPairs4(new int[]{1,1,1,1}));
        Assert.assertEquals(0, numIdenticalPairs4(new int[]{1,2,3}));
    }
}
