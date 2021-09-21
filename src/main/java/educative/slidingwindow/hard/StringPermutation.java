package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
Given a string and a pattern, find out if the string contains any permutation of the pattern.
Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations: abc,acb,bac,bca,cab,cba.
If a string has ‘n’ distinct characters, it will have n!n! permutations.

Input: String="oidbcaf", Pattern="abc" ... Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Input: String="odicf", Pattern="dc" ... Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Input: String="bcdxabcdy", Pattern="bcdyabcdx" ... Output: true
Explanation: Both the string and the pattern are a permutation of each other.
 */
public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        List<Character> patternLetters = new ArrayList<>();
        for (char c : pattern.toCharArray()) {
            patternLetters.add(c);
        }

        int windowStart = 0;
        List<Character> stringLetters = new ArrayList<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            stringLetters.add(str.charAt(windowEnd));

            if (stringLetters.size() == pattern.length()) {
                if (stringLetters.containsAll(patternLetters)) {
                    return true;
                } else {
                    char toRemove = str.charAt(windowStart);
                    stringLetters.remove(Character.valueOf(toRemove));
                    windowStart++;
                }
            }
        }

        return false;
    }

    @Test
    public void verify() {
        Assert.assertTrue(findPermutation("oidbcaf", "abc"));
        Assert.assertFalse(findPermutation("odicf", "dc"));
        Assert.assertTrue(findPermutation("bcdxabcdy", "bcdyabcdx"));
        Assert.assertTrue(findPermutation("aaacb", "abc"));
    }
}
