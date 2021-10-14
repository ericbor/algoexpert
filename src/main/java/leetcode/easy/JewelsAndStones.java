package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/jewels-and-stones/
public class JewelsAndStones {
    // O(J+S), O(J)
    public int numJewelsInStones(String jewels, String stones) {
        if (jewels == null || jewels.isEmpty()) {
            return 0;
        }

        Set<Character> jewelsSet = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelsSet.add(jewels.charAt(i));
        }

        int countJewels = 0;
        for (int k = 0; k < stones.length(); k++) {
            if (jewelsSet.contains(stones.charAt(k))) {
                countJewels++;
            }
        }

        return countJewels;
    }

    /*
    This is O(m*n) because the `indexOf` method of String class has to loop over the whole string and return the first index of the character you're looking for (or -1 otherwise).
    Essentially you're looping over the entire string J for every character of string S.
     */
    public int numJewelsInStones2(String jewels, String stones) {
        int countJewels = 0;
        for (int i = 0; i < stones.length(); i++) {
            int x = jewels.indexOf(stones.charAt(i));

            if (x != -1) {
                countJewels++;
            }

        }
        return countJewels;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, numJewelsInStones2("aA", "aAAbbbb"));
        Assert.assertEquals(0, numJewelsInStones2("z", "ZZ"));
    }
}
