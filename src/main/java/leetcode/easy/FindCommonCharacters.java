package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-common-characters/
public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[] last = count(words[0]);
        for (int i = 1; i < words.length; i++) {
            last = intersection(last, count(words[i]));
        }

        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = 'a';
                a += i;
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

    private int[] intersection(int[] a, int[] b) {
        int[] t = new int[26];
        for (int i = 0; i < 26; i++) {
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }

    private int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) {
            t[(int) c - (int) 'a']++;
        }
        return t;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("e", "l", "l"), commonChars(new String[] { "bella", "label", "roller" }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of("c","o"), commonChars(new String[] { "cool","lock","cook" }));
    }
}
