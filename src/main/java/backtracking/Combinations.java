package backtracking;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), 1, ans, n, k);
        return ans;
    }

    public void backtrack(List<Integer> curr, int firstNum, List<List<Integer>> ans, int n, int k) {
        if (curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        //int need = k - curr.size();
        //int remain = n - firstNum + 1;
        //int available = remain - need;

        for (int num = firstNum; num <= n; num++) {
            curr.add(num);
            backtrack(curr, num + 1, ans, n, k);
            curr.remove(curr.size() - 1);
        }
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of(1, 2), List.of(1, 3), List.of(1, 4), List.of(2, 3), List.of(2, 4), List.of(3, 4)), combine(4, 2));
    }
}
