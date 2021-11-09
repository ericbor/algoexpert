package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
public class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {

        int size = 3;
        int windowStart = 0;
        int counter = 0;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

            if(windowEnd == windowStart + size - 1) {
                char curr = s.charAt(windowEnd);
                char prev1 = s.charAt(windowEnd - 1);
                char prev2 = s.charAt(windowEnd - 2);
                if(curr != prev1 && curr != prev2 && prev1 != prev2) {
                    counter++;
                }

                windowStart++;
            }
        }

        return counter;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, countGoodSubstrings("xyzzaz"));
    }
}
