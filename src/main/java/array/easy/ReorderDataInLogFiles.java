package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = new Comparator<>() {
            @Override
            public int compare(String log1, String log2) {
                //Split each log into 2 parts: identifier and content
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                //case 1: both logs are letter-logs
                if (!isDigit1 && !isDigit2) {
                    //first compare the content
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) {
                        return cmp;
                    }
                    //logs of the same content, compare the identifiers
                    return split1[0].compareTo(split2[0]);
                }

                //case 2: one of logs is digit-log
                if (!isDigit1 && isDigit2) {
                    //the letter log comes before digit log
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    //case 3: both logs are digit-logs
                    return 0;
                }
            }
        };

        Arrays.sort(logs, myComp);
        return logs;
    }

    @Test
    public void verify() {
/*        Assert.assertArrayEquals(new String[] { "let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6" },
            reorderLogFiles(new String[] { "dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero" }));

        Assert.assertArrayEquals(new String[] { "g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7" },
            reorderLogFiles(new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo" }));*/

        Assert.assertArrayEquals(new String[] { "a2 act car", "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7" },
            reorderLogFiles(new String[] { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo", "a2 act car" }));
    }
}
