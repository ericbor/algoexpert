package string.easy;

import org.junit.Assert;
import org.junit.Test;

public class RunLengthEncoding {
    public String runLengthEncoding(String string) {
        StringBuilder sb = new StringBuilder();
        //the input string is guaranteed to be non-empty, so our first run will be of at least length 1
        int length = 1;

        for (int i = 1; i < string.length(); i++) {
            char current = string.charAt(i);
            char previous = string.charAt(i - 1);

            if (current != previous || length == 9) {
                sb.append(length);
                sb.append(previous);
                length = 0;
            }

            length++;
        }

        //Handle the last run
        sb.append(length);
        sb.append(string.charAt(string.length() - 1));

        return sb.toString();
    }

    @Test
    public void verify() {
        Assert.assertEquals("9A4A2B4C2D", runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }
}
