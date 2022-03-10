package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
public class MinDeletionsToMakeCharFrequenciesUnique {
    public int minDeletions(String s) {
        int[] hash = new int[26];
        for (char ch : s.toCharArray()) {
            hash[(int) ch - (int) 'a']++;
        }

        Set<Integer> used = new HashSet<>();
        int minDeletions = 0;

        for (int freq : hash) {
            while (freq > 0 && !used.add(freq)) {
                freq--;
                minDeletions++;
            }
        }

        return minDeletions;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, minDeletions("aabbcc"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(0, minDeletions("aab"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(2, minDeletions("ceabaacb"));
    }
}
