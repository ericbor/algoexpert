package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/distribute-candies-to-people/
public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] results = new int[num_people];

        int candiesToGive = 1;
        int person = 0;
        while(candies > 0) {

            if(candiesToGive > candies) {
                candiesToGive = candies;
            }

            results[person] += candiesToGive;
            candies -= candiesToGive;
            person++;
            candiesToGive++;

            if(person == num_people) {
                person = 0;
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{5,2,3}, distributeCandies(10, 3));
    }
}
