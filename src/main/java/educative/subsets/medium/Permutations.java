package educative.subsets.medium;

import com.sun.source.tree.AssertTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*
Permutation is defined as the re-arranging of the elements of the set. For example, {1, 2, 3} has the following six permutations:

Input: [1,3,5]
Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 */
public class Permutations {
    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());

        for (int currentNum : nums) {
            // we will take all existing permutations and add the current number to create new permutations
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                // create a new permutation by adding the current number at every position
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, currentNum);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        permutations.add(newPermutation);
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> findPermutationsBacktrack(int[] nums) {
        // init output list
        List<List<Integer>> result = new LinkedList<>();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        int n = nums.length;
        backtrack(n, numsList, result, 0);
        return result;
    }

    private static void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> result, int first) {
        // if all integers are used up
        if (first == n) {
            result.add(new ArrayList<>(nums));
        }
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, result, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    @Test
    public void main() {
        List<List<Integer>> result = findPermutations(new int[] { 1, 3, 5 });
        assertEquals(6, result.size());
        assertTrue(result.contains(List.of(1, 3, 5)));
        assertTrue(result.contains(List.of(1, 5, 3)));
        assertTrue(result.contains(List.of(3, 1, 5)));
        assertTrue(result.contains(List.of(3, 5, 1)));
        assertTrue(result.contains(List.of(5, 1, 3)));
        assertTrue(result.contains(List.of(5, 3, 1)));

        List<List<Integer>> resultBackTrack = findPermutationsBacktrack(new int[] { 1, 3, 5 });
        assertEquals(6, resultBackTrack.size());
        assertTrue(resultBackTrack.contains(List.of(1, 3, 5)));
        assertTrue(resultBackTrack.contains(List.of(1, 5, 3)));
        assertTrue(resultBackTrack.contains(List.of(3, 1, 5)));
        assertTrue(resultBackTrack.contains(List.of(3, 5, 1)));
        assertTrue(resultBackTrack.contains(List.of(5, 1, 3)));
        assertTrue(resultBackTrack.contains(List.of(5, 3, 1)));
    }
}
