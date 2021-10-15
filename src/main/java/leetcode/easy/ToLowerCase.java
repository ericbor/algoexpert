package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/to-lower-case/
public class ToLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                char cToUpper = (char) (c + 'a' - 'A');
                sb.append(cToUpper);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("hello", toLowerCase("HeLlo"));
        Assert.assertEquals("love", toLowerCase("love"));
        Assert.assertEquals("case", toLowerCase("CASE"));
    }
}
