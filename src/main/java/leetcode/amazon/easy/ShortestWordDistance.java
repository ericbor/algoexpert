package leetcode.amazon.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/shortest-word-distance/
public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int shortest = Integer.MAX_VALUE;

        int currentShortest = 0;
        List<String> occurances = new ArrayList<>();
        for(String word : wordsDict) {
            if(occurances.size() == 1) {
                currentShortest++;
            }

            if(word.equals(word1)) {
                if (occurances.contains(word)) {
                    currentShortest = 0;
                } else {
                    occurances.add(word);
                }
            } else if(word.equals(word2)) {
                if (occurances.contains(word)) {
                    currentShortest = 0;
                } else {
                    occurances.add(word);
                }
            }

            if(occurances.size() == 2) {
                shortest = Math.min(shortest, currentShortest);
                currentShortest = 0;
                occurances.remove(0);
            }
        }

        return shortest;
    }

    public int shortestDistance2(String[] words, String word1, String word2) {
        int i1 = -1;
        int i2 = -1;
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                i1 = i;
            } else if (words[i].equals(word2)) {
                i2 = i;
            }

            if (i1 != -1 && i2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(i1 - i2));
            }
        }
        return minDistance;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
        Assert.assertEquals(1, shortestDistance(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));

    }

    @Test
    public void test2() {
        //Assert.assertEquals(3, shortestDistance2(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
        Assert.assertEquals(1, shortestDistance2(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
    }
}
