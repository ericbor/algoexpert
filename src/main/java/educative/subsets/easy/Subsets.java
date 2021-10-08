package educative.subsets.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
Given a set with distinct elements, find all of its distinct subsets.

Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class Subsets {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for(int num : nums){
            int n = subsets.size();
            for(int i = 0; i < n; i++){
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(num);
                subsets.add(set);
            }
        }
        return subsets;
    }

    @Test
    public void main() {
        List<List<Integer>> result = findSubsets(new int[] { 1, 5, 3 });
        Assert.assertEquals(List.of(List.of(), List.of(1), List.of(5), List.of(1, 5), List.of(3), List.of(1, 3), List.of(5, 3), List.of(1, 5, 3)), result);
    }
}
