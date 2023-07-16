package backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, new ArrayList<>(), ans, candidates, target, 0);

        return ans;
    }

    private void backtrack(int currSum, List<Integer> curr, List<List<Integer>> ans, int[] candidates, int target, int start) {
        if (currSum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            currSum += candidates[i];
            curr.add(candidates[i]);
            backtrack(currSum, curr, ans, candidates, target, i);

            currSum -= curr.get(curr.size() - 1);
            curr.remove(curr.size() - 1);
        }
    }
}
