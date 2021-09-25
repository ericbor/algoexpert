package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Input: str1="xy#z", str2="xzz#" ... Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.

Input: str1="xy#z", str2="xyz#" ... Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.

Input: str1="xp#", str2="xyz##" ... Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.

Input: str1="xywrrmp", str2="xywrrmu#p" .... Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 */
public class BackspaceCompare {
    public static boolean compare(String str1, String str2) {
        int str1pointer = str1.length() - 1;
        int str2pointer = str2.length() - 1;

        while (str1pointer >= 0 || str2pointer >= 0) {
            str1pointer = getNextValidCharIndex(str1, str1pointer);
            str2pointer = getNextValidCharIndex(str2, str2pointer);

            if(str1pointer < 0 && str2pointer < 0) { //reached the end of both the strings
                return true;
            }
            if(str1pointer < 0 || str2pointer < 0) { //reached the end of one of the strings
                return false;
            }
            if(str1.charAt(str1pointer) != str2.charAt(str2pointer)) { // check if the characters are equal
                return false;
            }

            str1pointer--;
            str2pointer--;
        }

        return true;
    }

    public boolean backspaceCompare(String str1, String str2) {
        int str1index = str1.length() - 1;
        int str2index = str2.length() - 1;

        while (str1index >= 0 || str2index >= 0) { // While there may be chars in build(str1) or build (str2)
            str1index = getNextValidCharIndex(str1, str1index);
            str2index = getNextValidCharIndex(str2, str2index);
            // If two actual characters are different
            if (str1index >= 0 && str2index >= 0) {
                if(str1.charAt(str1index) != str2.charAt(str2index)) {
                    return false;
                }
            }
            // If expecting to compare char vs nothing
            if ((str1index >= 0) != (str2index >= 0)) {
                return false;
            }
            str1index--;
            str2index--;
        }

        return true;
    }

    private static int getNextValidCharIndex(String str, int index) {
        int backspaceCount = 0;
        while (index >= 0) { // Find position of next possible char in build(str1)
            if (str.charAt(index) == '#') {
                backspaceCount++;
                index--;
            } else if (backspaceCount > 0) {
                backspaceCount--;
                index--;
            } else {
                break;
            }
        }

        return index;
    }

    public boolean backspaceCompare2(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Deque<Character> ans = new ArrayDeque<>();
        //Stack<Character> ans = new Stack<>();
        for (char c: S.toCharArray()) {
            if (c != '#') {
                ans.push(c);
            } else if (!ans.isEmpty()) {
                ans.pop();
            }
        }
        return String.valueOf(ans);
    }

    @Test
    public void verify() {
        Assert.assertTrue(compare("xy#z", "xzz#"));
        Assert.assertFalse(compare("xy#z", "xyz#"));
        Assert.assertTrue(compare("xp#", "xyz##"));
        Assert.assertTrue(compare("xywrrmp", "xywrrmu#p"));

        Assert.assertTrue(backspaceCompare("xy#z", "xzz#"));
        Assert.assertFalse(backspaceCompare("xy#z", "xyz#"));
        Assert.assertTrue(backspaceCompare("xp#", "xyz##"));
        Assert.assertTrue(backspaceCompare("xywrrmp", "xywrrmu#p"));

        Assert.assertTrue(backspaceCompare2("xy#z", "xzz#"));
        Assert.assertFalse(backspaceCompare2("xy#z", "xyz#"));
        Assert.assertTrue(backspaceCompare2("xp#", "xyz##"));
        Assert.assertTrue(backspaceCompare2("xywrrmp", "xywrrmu#p"));
    }
}
