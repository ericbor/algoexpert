package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/partition-labels/
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            last[(int) s.charAt(i) - (int) 'a'] = i;
        }

        int j = 0;
        int anchor = 0;
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            int lastIndex = last[(int) s.charAt(i) - (int) 'a'];

            j = Math.max(j, lastIndex);

            if (i == j) {
                results.add(i - anchor + 1);
                anchor = i + 1;
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(9, 7, 8), partitionLabels("ababcbacadefegdehijhklij"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(10), partitionLabels("eccbbbbdec"));
    }
}
