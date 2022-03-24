package string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/valid-word-abbreviation/
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;
                ++j;
                continue;
            }

            if(Character.isLetter(word.charAt(i)) && Character.isLetter(abbr.charAt(j))) {
                return false;
            }
            if (abbr.charAt(j) == '0') {
                return false;
            }

            StringBuilder sb = new StringBuilder();
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                sb.append(abbr.charAt(j));
                ++j;
            }
            int num = Integer.parseInt(sb.toString());
            i += num;
        }

        return i == word.length() && j == abbr.length();
    }

    @Test
    public void test10() {
        Assert.assertFalse(validWordAbbreviation("apple", "a2e"));
    }

    @Test
    public void test2() {
        Assert.assertTrue(validWordAbbreviation("internationalization", "i12iz4n"));
    }

    @Test
    public void test4() {
        Assert.assertFalse(validWordAbbreviation("substitution", "s0ubstitution"));
    }

    @Test
    public void test() {
        Assert.assertTrue(validWordAbbreviation("substitution", "12"));
    }

    @Test
    public void test5() {
        Assert.assertFalse(validWordAbbreviation("substitution", "s55n"));
    }

    @Test
    public void test8() {
        Assert.assertTrue(validWordAbbreviation("substitution", "sub4u4"));
    }

    @Test
    public void test3() {
        Assert.assertTrue(validWordAbbreviation("substitution", "s10n"));
    }

    @Test
    public void test6() {
        Assert.assertTrue(validWordAbbreviation("substitution", "su3i1u2on"));
    }

    @Test
    public void test7() {
        Assert.assertTrue(validWordAbbreviation("substitution", "substitution"));
    }

    @Test
    public void test9() {
        Assert.assertFalse(validWordAbbreviation("substitution", "s010n"));
    }
}
