package other;

import org.junit.Assert;

//https://leetcode.com/problems/random-pick-with-weight/editorial/
public class RandomPickWithWeight {

    private final int[] prefixSums;
    private final int totalSum;

    public RandomPickWithWeight(int[] w) {
        prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            prefixSums[i] = prefixSum;
        }
        totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = totalSum * Math.random();
        int i = 0;
        // run a linear search to find the target zone
        while (i < prefixSums.length) {
            if (target < prefixSums[i]) {
                return i;
            }
            i++;
        }

        // to have a return statement, though this should never happen.
        return i - 1;
    }

    public static void main(String[] args) {
        RandomPickWithWeight rand = new RandomPickWithWeight(new int[]{1,3});
        Assert.assertEquals(1, rand.pickIndex());
    }
}
