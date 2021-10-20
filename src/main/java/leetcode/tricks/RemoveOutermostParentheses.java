package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/remove-outermost-parentheses/
public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (counter != 0) {
                    sb.append(c);
                }
                counter++;
            } else {
                counter--;
                if (counter != 0) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("()()()()(())", removeOuterParentheses("(()())(())(()(()))"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("()()()", removeOuterParentheses("(()())(())"));
    }
}
