package other;

import org.junit.Assert;
import org.junit.Test;

public class RepeatingString {
    public static long repeatedString(String s, long n) {
        long aCount = 0;

        for (int i = 0; i < Math.min(n, s.length()); i++) {
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        if (n <= s.length()) {
            return aCount;
        }

        if (aCount == s.length()) {
            return n;
        }

        long div = n / s.length();
        aCount *= div;

        if (n % s.length() != 0) {
            long reminderLength = n % s.length();
            for (int i = 0; i < reminderLength; i++) {
                if (s.charAt(i) == 'a') {
                    aCount++;
                }
            }
        }

        return aCount;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, repeatedString("bab", 10));
    }
}
