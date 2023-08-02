package string.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
public class FindWordsThatCanBeFormedByChars {
    public int countCharacters(String[] words, String chars) {
        int[] alphabet = new int[26];

        for (char c : chars.toCharArray()) {
            int index = (int) c - (int) 'a';
            alphabet[index]++;
        }

        int totalResult = 0;
        for (String word : words) {
            int[] letterCounter = new int[26];
            for (char c : word.toCharArray()) {
                int index = (int) c - (int) 'a';
                letterCounter[index]++;
            }

            int localResult = 0;
            for (int i = 0; i < letterCounter.length; i++) {
                if (letterCounter[i] != 0) {
                    if (alphabet[i] >= letterCounter[i]) {
                        localResult += letterCounter[i];
                    }
                }
            }

            if (localResult == word.length()) {
                totalResult += localResult;
            }
        }

        return totalResult;
    }

    public int countCharacters2(String[] words, String chars) {
        int[] alphabet = new int[26];

        for (char c : chars.toCharArray()) {
            int index = (int) c - (int) 'a';
            alphabet[index]++;
        }

        int totalResult = 0;
        for (String word : words) {
            int[] letterCounter = new int[26];
            int localResult = 0;
            for (char c : word.toCharArray()) {
                int index = (int) c - (int) 'a';
                letterCounter[index]++;

                if (alphabet[index] >= letterCounter[index]){
                    localResult++;
                } else {
                    break;
                }

            }
            if (localResult == word.length()) {
                totalResult += localResult;
            }
        }

        return totalResult;
    }

    public int countCharactersNew(String[] words, String chars) {
        int[] hash = new int[26];
        for(char c: chars.toCharArray()) {
            hash[(int)c - (int)'a']++;
        }

        int results = 0;
        for(String word: words) {
            if(isGood(word, hash)) {
                results += word.length();
            }
        }

        return results;
    }

    private boolean isGood(String word, int[] hash) {
        int[] wordHash = new int[26];
        for(char c: word.toCharArray()) {
            wordHash[(int)c - (int)'a']++;
        }

        for(int i = 0; i < wordHash.length; i++) {
            if(wordHash[i] > 0) {
                if(wordHash[i] < hash[i]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void verify() {
        //Assert.assertEquals(6, countCharacters(new String[] { "cat", "bt", "hat", "tree" }, "atach"));
        //Assert.assertEquals(10, countCharacters(new String[] { "hello", "world", "leetcode" }, "welldonehoneyr"));

        Assert.assertEquals(6, countCharacters2(new String[] { "cat", "bt", "hat", "tree" }, "atach"));
        Assert.assertEquals(10, countCharacters2(new String[] { "hello", "world", "leetcode" }, "welldonehoneyr"));

        Assert.assertEquals(10, countCharactersNew(new String[] { "hello", "world", "leetcode" }, "welldonehoneyr"));

    }

}
