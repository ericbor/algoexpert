package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
public class CheckAllCharactersHaveEqualNumberOfOccurrences {
    public boolean areOccurrencesEqual(String s) {
        int[] frequencies = new int[26];

        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }

        int previous = -1;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                if (previous > 0) {
                    if (previous != frequencies[i]) {
                        return false;
                    } else {
                        previous = frequencies[i];
                    }
                } else {
                    previous = frequencies[i];
                }
            }
        }

        return true;
    }

    @Test
    public void test() {
        Assert.assertFalse(areOccurrencesEqual("aaabb"));
    }
}
