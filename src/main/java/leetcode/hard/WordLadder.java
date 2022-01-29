package leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/word-ladder/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> set = new HashSet<>(wordList);
        set.add(endWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int length = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return length + 1;
                }

                wordMatch(curr, set, queue);
            }
            length++;
        }

        return 0;
    }

    private void wordMatch(String w, Set<String> set, Queue<String> queue) {
        for (int i = 0; i < w.length(); i++) {
            char[] word = w.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                word[i] = ch;
                String s = new String(word);
                if (set.contains(s)) {
                    queue.add(s);
                    set.remove(s);
                }
            }
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(5, ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
