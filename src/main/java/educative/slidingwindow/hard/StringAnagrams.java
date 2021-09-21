package educative.slidingwindow.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
/*
Given a string and a pattern, find all anagrams of the pattern in the given string.
Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters while finding permutations of a string, we get N!N! permutations (or anagrams) of a string having NN characters. For example, here are the six anagrams of the string “abc”:
Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

Input: String="ppqp", Pattern="pq" ... Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

Input: String="abbcabc", Pattern="abc" ... Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */
public class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Character> patternLetters = new ArrayList<>();
        for (char c : pattern.toCharArray()) {
            patternLetters.add(c);
        }

        int windowStart = 0;
        List<Character> strLetters = new ArrayList<>();
        List<Integer> resultIndices = new ArrayList<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            strLetters.add(str.charAt(windowEnd));

            if (strLetters.size() == patternLetters.size()) {
                if (strLetters.containsAll(patternLetters)) {
                    resultIndices.add(windowStart);
                }
                char toRemove = str.charAt(windowStart);
                strLetters.remove(Character.valueOf(toRemove));
                windowStart++;
            }
        }

        return resultIndices;
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(1, 2), findStringAnagrams("ppqp", "pq"));
        Assert.assertEquals(List.of(2, 3, 4), findStringAnagrams("abbcabc", "abc"));
    }
}
