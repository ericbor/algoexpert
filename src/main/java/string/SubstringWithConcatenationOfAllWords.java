package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words
public class SubstringWithConcatenationOfAllWords {
    private Map<String, Integer> wordCount = new HashMap<>();
    private int wordLength;
    private int substringSize;
    private int k;



    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n - substringSize + 1; i++) {
            if (check(i, s)) {
                answer.add(i);
            }
        }

        return answer;
    }

    private boolean check(int i, String s) {
        // Copy the original dictionary to use for this index
        Map<String, Integer> remaining = new HashMap<>(wordCount);
        int wordsUsed = 0;

        // Each iteration will check for a match in words
        for (int j = i; j < i + substringSize; j += wordLength) {
            String sub = s.substring(j, j + wordLength);
            if (remaining.getOrDefault(sub, 0) == 0) {
                break;
            } else {
                remaining.put(sub, remaining.get(sub) - 1);
                wordsUsed++;
            }
        }

        return wordsUsed == k;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(0,9), findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}
