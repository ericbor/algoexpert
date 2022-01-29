package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInString {
    public List<Integer> findAnagrams_2(String s, String p) {
        int pLength = p.length();

        char[] pArr = new char[26];
        for(char c: p.toCharArray()) {
            pArr[c - 'a']++;
        }

        List<Integer> results = new ArrayList<>();

        for(int i = 0; i <= s.length() - p.length(); i++) {
            if(p.indexOf(s.charAt(i)) != -1) {
                char[] match = new char[26];
                for(int j = i; j < i + pLength; j++) {
                    match[s.charAt(j) - 'a']++;
                }

                boolean isMatch = true;
                for(int k = 0; k < pArr.length; k++) {
                    if(pArr[k] != match[k]) {
                        isMatch = false;
                        break;
                    }
                }

                if(isMatch) {
                    results.add(i);
                }
            }
        }

        return results;
    }

    public List<Integer> findAnagrams(String s, String p) {

        int [] pCount = new int[26];
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
            if (Arrays.equals(pCount, sCount)) {
                output.add(start);
            }
        }

        return output;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(0, 6), findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(0, 1, 2), findAnagrams("abab", "ab"));
    }
}
