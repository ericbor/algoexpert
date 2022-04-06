package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams_2(String s, String p) {

        char[] pCount = new char[26];
        for (char c : p.toCharArray()) {
            pCount[(int) c - (int) 'a']++;
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (p.indexOf(s.charAt(i)) != -1) {
                char[] match = new char[26];
                for (int j = i; j < i + p.length(); j++) {
                    match[(int) s.charAt(j) - (int) 'a']++;
                }

                boolean isMatch = true;
                for (int k = 0; k < pCount.length; k++) {
                    if (pCount[k] != match[k]) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    results.add(i);
                }
            }
        }

        return results;
    }

    public List<Integer> findAnagrams(String s, String p) {

        int[] pCount = new int[26];
        // build reference array using string p
        for (char ch : p.toCharArray()) {
            pCount[(int) ch - (int) 'a']++;
        }

        List<Integer> output = new ArrayList<>();
        // sliding window on the string s
        int[] sCount = new int[26];
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            sCount[(int) s.charAt(i) - (int) 'a']++;

            // remove one letter from the left side of the window
            if (i >= p.length()) {
                sCount[(int) s.charAt(start) - (int) 'a']--;
                start++;
            }

            // compare array in the sliding window with the reference array
            if (Arrays.equals(pCount, sCount)) { //O(N)
                output.add(start);
            }
        }

        return output;
    }

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<>();
        // our goal is to match all the characters from the map with the current window
        int start = 0;
        int matched = 0;
        for (int i = 0; i < str.length(); i++) {
            char rightChar = str.charAt(i);
            // decrement the frequency of the matched character
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == map.size()) {
                // have we found an anagram?
                resultIndices.add(start);
            }

            if (i >= pattern.length() - 1) { // shrink the window
                char leftChar = str.charAt(start);
                start++;
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) == 0) {
                        matched--; // before putting the character back, decrement the matched count
                    }
                    // put the character back
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }

        return resultIndices;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(0, 6), findAnagrams("cbaebabacd", "abc"));
        Assert.assertEquals(List.of(0, 6), findStringAnagrams("cbaebabacd", "abc"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(0, 1, 2), findAnagrams("abab", "ab"));
        Assert.assertEquals(List.of(0, 1, 2), findStringAnagrams("abab", "ab"));
    }
}
