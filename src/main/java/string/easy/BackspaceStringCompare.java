package string.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

//https://leetcode.com/problems/backspace-string-compare
public class BackspaceStringCompare {
    //Time: O(N+M), Space: O(N+M)
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String str) {
        Stack<Character> input = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                input.push(c);
            } else if (!input.isEmpty()) {
                input.pop();
            }
        }

        return String.valueOf(input);
    }

    //Time: O(N+M), Space: O(1)
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int skipS = 0;
        int skipT = 0;

        //while there are chars in S and T
        while (i >= 0 || j >= 0) {
            //Find position of next possible char in S
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            //Find position of next possible char in T
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }

    @Test
    public void verify() {
        //Assert.assertTrue(backspaceCompare("ab#c", "ad#c"));
        //Assert.assertTrue(backspaceCompare("ab##", "c#d#"));
        //Assert.assertFalse(backspaceCompare("a#c", "b"));
        Assert.assertTrue(backspaceCompare("a##c", "#a#c"));

        //Assert.assertTrue(backspaceCompare2("ab#c", "ad#c"));
        //Assert.assertTrue(backspaceCompare2("ab##", "c#d#"));
        //Assert.assertFalse(backspaceCompare2("a#c", "b"));
        //Assert.assertTrue(backspaceCompare2("a##c", "#a#c"));
    }
}
