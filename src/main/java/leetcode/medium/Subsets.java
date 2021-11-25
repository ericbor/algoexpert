package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/subsets/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : subsets) {
                List<Integer> list = new ArrayList<>(curr);
                list.add(num);

                newSubsets.add(list);
            }

            subsets.addAll(newSubsets);
        }

        return subsets;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(Collections.emptyList(), List.of(1), List.of(2), List.of(1, 2), List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3)), subsets(new int[] { 1, 2, 3 }));
    }
}
