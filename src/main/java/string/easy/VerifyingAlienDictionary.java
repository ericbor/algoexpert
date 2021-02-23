package string.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/verifying-an-alien-dictionary/
public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            dictionary.put(order.charAt(i), i);
        }

        Comparator<String> alienComp = new Comparator<>() {
            @Override
            public int compare(String w1, String w2) {

                return compareStrings(w1, w2, dictionary);
            }
        };

        String[] copyWords = Arrays.copyOf(words, words.length);
        Arrays.sort(copyWords, alienComp);

        return Arrays.equals(copyWords, words);
    }

    public boolean isAlienSorted2(String[] words, String order) {
        Map<Character, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            dictionary.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i+1];

            // Find the first difference word1[k] != word2[k].
            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    // If they compare badly, it's not sorted.
                    if (dictionary.get(word1.charAt(k)) > dictionary.get(word2.charAt(k))) {
                        return false;
                    }
                    break;
                }
            }

            if (word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }

    private int compareStrings(String w1, String w2, Map<Character, Integer> dictionary) {
        int index = 0;
        while ( w1.length() > index && w2.length() > index) {
            char char1 = w1.charAt(index);
            char char2 = w2.charAt(index);
            int char1order = dictionary.get(char1);
            int char2order = dictionary.get(char2);

            if (char1order < char2order) {
                return -1;
            }
            if (char1order > char2order) {
                return 1;
            }

            index++;
        }

        if(w1.length() > w2.length()) {
            return 1;
        }
        if(w1.length() < w2.length()) {
            return -1;
        }

        return 0;
    }

    @Test
    public void verify() {
        //Assert.assertTrue(isAlienSorted(new String[]{"app","apple"}, "abcdefghijklmnopqrstuvwxyz"));
        //Assert.assertFalse(isAlienSorted(new String[]{"my","f"}, "gelyriwxzdupkjctbfnqmsavho"));
        //Assert.assertFalse(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        //Assert.assertFalse(isAlienSorted(new String[]{"word","world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        //Assert.assertTrue(isAlienSorted(new String[]{"ubg","kwh"}, "qcipyamwvdjtesbghlorufnkzx"));
        //Assert.assertTrue(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));

        Assert.assertTrue(isAlienSorted2(new String[]{"app","apple"}, "abcdefghijklmnopqrstuvwxyz"));
        Assert.assertFalse(isAlienSorted2(new String[]{"my","f"}, "gelyriwxzdupkjctbfnqmsavho"));
        Assert.assertFalse(isAlienSorted2(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        Assert.assertFalse(isAlienSorted2(new String[]{"word","world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        Assert.assertTrue(isAlienSorted2(new String[]{"ubg","kwh"}, "qcipyamwvdjtesbghlorufnkzx"));
        Assert.assertTrue(isAlienSorted2(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
