package leetcode.medium.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/
public class WordBreak {

    // O(2^N), O(N)
    public boolean wordBreakBF(String s, List<String> wordDict) {
        return wordBreakHelper(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakHelper(String s, Set<String> wordDict, int start) {
        if (s.length() == start) {
            return true;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (wordDict.contains(substring)) {
                if (wordBreakHelper(s, wordDict, end)) {
                    return true;
                }
            }
        }

        return false;
    }

    // O(N^3), O(N)
    public boolean wordBreakMemo(String s, List<String> wordDict) {
        Boolean[] cache = new Boolean[s.length()];
        return wordBreakHelperMemo(s, new HashSet<>(wordDict), 0, cache);
    }

    private boolean wordBreakHelperMemo(String s, Set<String> wordDict, int start, Boolean[] cache) {
        if (s.length() == start) {
            return true;
        }
        if (cache[start] != null) {
            return cache[start];
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            if (wordDict.contains(substring)) {
                if (wordBreakHelperMemo(s, wordDict, end, cache)) {
                    cache[start] = true;
                    return cache[start];
                }
            }
        }

        cache[start] = false;
        return cache[start];
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {

                String substring = s.substring(j, i + 1);
                if (wordDictSet.contains(substring)) {
                    if (dp[j]) {
                        dp[i + 1] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test() {
        Assert.assertTrue(wordBreakBF("leetcode", List.of("leet", "code")));
        Assert.assertTrue(wordBreakMemo("leetcode", List.of("leet", "code")));
        Assert.assertTrue(wordBreakDP("leetcode", List.of("leet", "code")));
    }

    @Test
    public void test2() {
        Assert.assertTrue(wordBreakBF("applepenapple", List.of("apple", "pen")));
        Assert.assertTrue(wordBreakMemo("applepenapple", List.of("apple", "pen")));
        Assert.assertTrue(wordBreakDP("applepenapple", List.of("apple", "pen")));
    }

    @Test
    public void test3() {
        Assert.assertFalse(wordBreakBF("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        Assert.assertFalse(wordBreakMemo("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        Assert.assertFalse(wordBreakDP("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
