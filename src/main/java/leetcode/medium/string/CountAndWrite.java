package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/custom-sort-string/solution/
public class CountAndWrite {
    public String customSortString(String order, String s) {
        // count[char] = the number of occurrences of 'char' in s.
        // This is offset so that count[0] = occurrences of 'a', etc.
        // 'count' represents the current state of characters
        // (with multiplicity) we need to write to our answer.
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[(int) c - (int) 'a']++;
        }

        // ans will be our final answer.  We use StringBuilder to join
        // the answer so that we more efficiently calculate a
        // concatenation of strings.
        StringBuilder ans = new StringBuilder();

        // Write all characters that occur in order, in the order of order.
        for (char c: order.toCharArray()) {
            int idx = (int) c - (int) 'a';

            for (int i = 0; i < count[idx]; i++) {
                ans.append(c);
            }
            // Setting count[char] to zero to denote that we do
            // not need to write 'char' into our answer anymore.
            count[idx] = 0;
        }

        // Write all remaining characters that don't occur in order.
        // That information is specified by 'count'.
        for (char c = 'a'; c <= 'z'; c++) {
            int idx = (int) c - (int) 'a';
            for (int i = 0; i < count[idx]; i++) {
                ans.append(c);
            }
        }

        return ans.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("cbad", customSortString("cba", "abcd"));
    }
}
