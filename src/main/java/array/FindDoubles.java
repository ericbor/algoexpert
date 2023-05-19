package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/discuss/interview-question/3268118/Pure-Storage-or-OA-2022
public class FindDoubles {
    public List<Integer> findDoubles(int[] nums) {
        int[] hash = new int[1000];
        for (int num : nums) {
            hash[num]++;
        }

        List<Integer> results = new ArrayList<>();
        if (hash[0] == 1) {
            results.add(0);
        }

        for (int i = 1; i < hash.length; i++) {
            if (hash[i] > 0) {
                int dbl = i * 2;
                if (hash[dbl] == 1) {
                    for (int k = 0; k < hash[i]; k++) {
                        results.add(i);
                    }
                }
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(0, 1, 2, 3), findDoubles(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(Collections.emptyList(), findDoubles(new int[]{7, 17, 11, 1, 23}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(List.of(1, 1), findDoubles(new int[]{1, 1, 2}));
    }

}
