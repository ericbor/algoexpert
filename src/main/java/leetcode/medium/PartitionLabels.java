package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/partition-labels/
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[(int) s.charAt(i) - (int) 'a'] = i;
        }

        int end = 0;
        int start = 0;
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int lastIndex = last[(int) s.charAt(i) - (int) 'a'];

            end = Math.max(end, lastIndex);

            if (i == end) {
                results.add(end - start + 1);
                start = end + 1;
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
