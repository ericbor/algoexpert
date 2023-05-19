package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-repeating-substring
public class MaximumRepeatingSubstring {
    public int maxRepeating2(String sequence, String word) {
        if (sequence.equals(word)) {
            return 1;
        }

        int count = 0;
        if (word.length() == 1) {
            count = getMaxRepeating(sequence, word, 0);
        } else {
            for (int i = 0; i < sequence.length(); i++) {
                count = Math.max(count, getMaxRepeating(sequence, word, i));
            }
        }


        return count;
    }

    private int getMaxRepeating(String s, String w, int i) {
        int start = i;
        int end = i;
        int count = 0;
        int prev = -1;
        int maxCount = Integer.MIN_VALUE;

        while (end + w.length() <= s.length()) {
            end += w.length();
            String sub = s.substring(start, end);
            if (sub.equals(w)) {
                if (prev == -1) {
                    count++;
                } else if (start - prev == w.length()) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
                prev = start;
            }

            start = end;
        }

        return Math.max(maxCount, count);
    }

    public int maxRepeating(String sequence, String word) {
        int repeating = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            repeating++;
            sb.append(word);
        }
        return repeating;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, maxRepeating("ababc", "ab"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, maxRepeating("ababc", "ba"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, maxRepeating("ababc", "ac"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(1, maxRepeating("a", "a"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(5, maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

    @Test
    public void test6() {
        Assert.assertEquals(5, maxRepeating("bababbbaabbaaabbbabbaaaaabaabbaaabaab", "a"));
    }
}
