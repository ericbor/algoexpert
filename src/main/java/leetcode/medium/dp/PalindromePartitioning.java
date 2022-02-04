package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    private final List<List<String>> results = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        helper(new ArrayList<>(), s, 0);

        return results;
    }

    private void helper(List<String> path, String s, int i) {
        if (i == s.length()) {
            results.add(new ArrayList<>(path));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (dp[i][j]) {
                path.add(s.substring(i, j + 1));
                helper(path, s, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of("a", "a", "b"), List.of("aa", "b")), partition("aab"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(List.of("r", "a", "c", "e", "c", "a", "r"), List.of("r", "a", "cec", "a", "r"), List.of("r", "aceca", "r"), List.of("racecar")), partition("racecar"));
    }
}
