package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
public class RedistributeCharacters {
    public boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                freq[(int) c - (int) 'a']++;
            }
        }

        for (int frequency : freq) {
            if(frequency % words.length != 0){
                return false;
            }
        }

        return true;
    }

    @Test
    public void test6() {
        Assert.assertFalse(makeEqual(new String[] { "ccc","abbb"}));
    }

    @Test
    public void test5() {
        Assert.assertTrue(makeEqual(new String[] { "caaaaa","aaaaaaaaa","a","bbb","bbbbbbbbb","bbb","cc","cccccccccccc","ccccccc","ccccccc","cc","cccc","c","cccccccc","c" }));
    }

    @Test
    public void test() {
        Assert.assertTrue(makeEqual(new String[] { "b" }));
    }

    @Test
    public void test2() {
        Assert.assertFalse(makeEqual(new String[] { "a", "b" }));
    }

    @Test
    public void test3() {
        Assert.assertTrue(makeEqual(new String[] { "abc", "aabc", "bc" }));
    }

    @Test
    public void test4() {
        Assert.assertFalse(makeEqual(new String[] { "ab", "a" }));
    }
}
