package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/positions-of-large-groups/
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> results = new ArrayList<>();

        char prev = s.charAt(0);
        int startIdx = 0;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (prev != curr) {
                if (i - startIdx >= 3) {
                    results.add(Arrays.asList(startIdx, i - 1));
                }
                startIdx = i;
            }

            prev = curr;
        }

        if (s.length() - startIdx >= 3) {
            results.add(Arrays.asList(startIdx, s.length() - 1));
        }

        return results;
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0; // i is the start of each group
        for (int j = 0; j < s.length(); ++j) {
            if (j == s.length() - 1 || s.charAt(j) != s.charAt(j + 1)) {
                // Here, [i, j] represents a group.
                if (j - i + 1 >= 3) {
                    ans.add(Arrays.asList(i, j));
                }
                i = j + 1;
            }
        }

        return ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of(3, 6)), largeGroupPositions("abbxxxxzzy"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(List.of(0, 2)), largeGroupPositions("aaa"));
    }
}
