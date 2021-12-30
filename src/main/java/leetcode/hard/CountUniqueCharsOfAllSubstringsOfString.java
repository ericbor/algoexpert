package leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
public class CountUniqueCharsOfAllSubstringsOfString {

    private final Map<char[], Integer> map = new HashMap<>();

    public int uniqueLetterString2(String s) {
        int counter = 0;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start, end);
                counter += getUniqueChars(substring);
                ;
            }
        }

        return counter;
    }

    private int getUniqueChars(String s) {
        if (s.length() == 1) {
            return 1;
        }

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        if (map.containsKey(arr)) {
            return map.get(arr);
        }

        int[] freq = new int[26];
        for (char c : arr) {
            freq[(int) c - (int) 'A']++;
        }

        int uniqueCounter = 0;
        for (int num : freq) {
            if (num == 1) {
                uniqueCounter++;
            }
        }

        map.put(arr, uniqueCounter);

        return uniqueCounter;
    }

    public int uniqueLetterString(String s) {
        int[] used = new int[26];
        used[(int) s.charAt(0) - (int) 'A']++;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        int[] unused = new int[26];
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = (int) c - (int) 'A';
            int totalz_e = dp[i - 1] + i + 1;
            dp[i] = totalz_e - 2 * used[idx] - unused[idx];

            unused[idx] += used[idx];
            used[idx] = i + 1 - unused[idx];
        }

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += dp[i];
        }

        System.out.println(Arrays.toString(dp));
        return sum;
    }

    @Test
    public void test4() {
        Assert.assertEquals(10, uniqueLetterString("ABC"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(8, uniqueLetterString("ABA"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(92, uniqueLetterString("LEETCODE"));
    }
}
