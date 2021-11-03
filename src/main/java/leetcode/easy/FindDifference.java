package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/find-the-difference/
public class FindDifference {
    public char findTheDifference(String s, String t) {
        int[] frequencies = new int[26];

        for(char c: s.toCharArray()) {
            frequencies[(int)c - (int)'a']++;
        }
        for(char c: t.toCharArray()) {
            frequencies[(int)c - (int)'a']--;
        }

        char answer = '1';
        for(int i = 0; i < frequencies.length; i++) {
            if(frequencies[i] < 0) {
                int ascii = (int)'a' + i;
                answer = (char)ascii;
                break;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        Assert.assertEquals('e', findTheDifference("abcd", "abcde"));
    }
}
