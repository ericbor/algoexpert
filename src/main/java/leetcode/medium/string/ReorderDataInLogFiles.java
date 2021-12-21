package leetcode.medium.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            // split each log into two parts: <identifier, content>
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // case 1). both logs are letter-logs
            if (!isDigit1 && !isDigit2) {
                // first compare the content
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) {
                    return cmp;
                }
                // logs of same content, compare the identifiers
                return split1[0].compareTo(split2[0]);
            }

            // case 2). one of logs is digit-log
            if (!isDigit1 && isDigit2) {
                return -1; // the letter-log comes before digit-logs
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else { // case 3). both logs are digit-log
                return 0;
            }
        });

        return logs;
    }

    @Test
    public void test() {
        String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
        Assert.assertArrayEquals(new String[] { "let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6" }, reorderLogFiles(logs));
    }

    @Test
    public void test2() {
        String[] logs = { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" };
        Assert.assertArrayEquals(new String[] { "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7" }, reorderLogFiles(logs));
    }
}
