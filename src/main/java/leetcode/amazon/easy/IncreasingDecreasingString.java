package leetcode.amazon.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/increasing-decreasing-string/
public class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] frequencies = new int['z' + 1];

        int from = Integer.MAX_VALUE;
        int to = Integer.MIN_VALUE;
        for (char c : s.toCharArray()) {
            from = Math.min(from, c);
            to = Math.max(to, c);
            frequencies[c]++;
        }

        StringBuilder sb = new StringBuilder();
        boolean ascending = true;
        while (sb.length() < s.length()) {
            if (ascending) {
                for (int i = from; i <= to; i++) {
                    if (frequencies[i] != 0) {
                        sb.append((char) i);
                        frequencies[i]--;
                    }
                }
            } else {
                for (int i = to; i >= from; i--) {
                    if (frequencies[i] != 0) {
                        sb.append((char) i);
                        frequencies[i]--;
                    }
                }
            }

            ascending = !ascending;
        }

        return sb.toString();
    }

    public String sortString2(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[(int) ch - (int) 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) (i + (int) 'a'));
                    freq[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) (i + (int) 'a'));
                    freq[i]--;
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("abccbaabccba", sortString("aaaabbbbcccc"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("abccbaabccba", sortString2("aaaabbbbcccc"));
    }
}
