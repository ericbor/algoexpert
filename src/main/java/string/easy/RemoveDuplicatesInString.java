package string.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveDuplicatesInString {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(0);

        for (char character : s.toCharArray()) {
            int removeIndex = sb.length() - 1;
            if (sb.length() != 0 && character == sb.charAt(removeIndex)) {
                sb.deleteCharAt(removeIndex);
            } else {
                sb.append(character);
            }
        }

        return sb.toString();
    }

    private void foo() {

    }

    @Test
    public void verify() {
        Assert.assertEquals("ca", removeDuplicates("abbaca"));
    }
}
