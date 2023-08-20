package dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/word-break-ii
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(i, new HashSet<>());
        }

        for (int i = 0; i < s.length(); i++) {
            // find all sentence can be made up by substring s[i]
            // s[i] = substring s[0:j] workBreak + word in wordDict || s[i] is a word in wordDict
            // map[i] = map[i - 1] each in set + word
            String word = s.substring(0, i + 1);
            if (set.contains(word)) {
                map.get(i).add(word);
            }

            for (int j = 0; j < i; j++) {
                // s[0 : j] inclusively
                String tmp = s.substring(j + 1, i + 1);
                if (!map.get(j).isEmpty() && set.contains(tmp)) {
                    for (String prevSentence : map.get(j)) {
                        map.get(i).add(prevSentence + " " + tmp);
                    }
                }
            }
        }

        return new ArrayList<>(map.get(s.length() - 1));
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("cat sand dog", "cats and dog"), wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of("pineapple pen apple", "pine applepen apple", "pine apple pen apple"), wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple")));
    }
}
