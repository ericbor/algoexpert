package leetcode.amazon.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
public class CountSubstringsWithOnlyOneDistinctLetter {
    public int countLetters(String s) {
        int total = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                count++;
            } else {
                count = 1;
            }
            total += count;
        }
        return total;
    }

    @Test
    public void test() {
        //aaa (3 - a, 2 - aa, 1 - aaa): length 3 means 3 + 2 + 1
        Assert.assertEquals(8, countLetters("aaaba"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(55, countLetters("aaaaaaaaaa"));
    }
}
