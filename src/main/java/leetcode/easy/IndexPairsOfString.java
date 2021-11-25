package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/index-pairs-of-a-string/
public class IndexPairsOfString {
    public int[][] indexPairs2(String text, String[] words) {
        List<int[]> results = new ArrayList<>();

        for (String word : words) {
            int start = 0;
            int end = text.length() - word.length();

            while(text.charAt(start) != word.charAt(0)) {
                start++;
            }

            while (start <= end) {
                int currLength = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == text.charAt(start + i)) {
                        currLength++;
                    } else {
                        break;
                    }
                }

                if (currLength == word.length()) {
                    results.add(new int[] { start, start + word.length() - 1 });
                }
                start++;
            }
        }

        int[][] answers = new int[results.size()][2];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = results.get(i);
        }

        Arrays.sort(answers, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        return answers;
    }

    public int[][] indexPairs(String text, String[] words) {
        List<int[]> res = new ArrayList<>();
        for (String word : words) {
            int index = 0;

            while (index != -1) {
                index = text.indexOf(word, index);
                if (index != -1) {
                    res.add(new int[] { index, index + word.length() - 1 });
                    index++;
                }
            }
        }

        Collections.sort(res, (a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        return res.toArray(new int[0][]);
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[][] { { 3, 7 }, { 9, 13 }, { 10, 17 } }, indexPairs("thestoryofleetcodeandme", new String[] { "story","fleet","leetcode" }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } }, indexPairs("ababa", new String[] { "aba", "ab" }));
    }
}
