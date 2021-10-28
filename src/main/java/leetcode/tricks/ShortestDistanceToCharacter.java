package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/shortest-distance-to-a-character/
public class ShortestDistanceToCharacter {
    public int[] shortestToChar(String s, char c) {
        int[] results = new int[s.length()];

        int prev = Integer.MIN_VALUE / 2;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                prev = i;
            }

            results[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == c) {
                prev = i;
            }

            results[i] = Math.min(results[i], prev - i);
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] {3,2,1,0,1,0,0,1,2,2,1,0}, shortestToChar("loveleetcode", 'e'));
    }
}
