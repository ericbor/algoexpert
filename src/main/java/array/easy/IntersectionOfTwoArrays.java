package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays {
    //Time: O(n+m), Space: O(n+m)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num2 : nums2) {
            set2.add(num2);
        }

        if (set1.size() < set2.size()) {
            return setIntersection(set1, set2);
        }

        return setIntersection(set2, set1);
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num2 : nums2) {
            set2.add(num2);
        }

        set1.retainAll(set2);

        List<Integer> results = new ArrayList<>();
        for (Integer num : set1) {
            if (set2.contains(num)) {
                results.add(num);
            }
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    private int[] setIntersection(Set<Integer> set1, Set<Integer> set2) {
        List<Integer> results = new ArrayList<>();

        for (Integer num : set1) {
            if (set2.contains(num)) {
                results.add(num);
            }
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    @Test
    public void verify() {
        Assert.assertArrayEquals(new int[] { 2 }, intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }));
        Assert.assertArrayEquals(new int[] { 4, 9 }, intersection(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }));
        Assert.assertArrayEquals(new int[] { 2 }, intersection2(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }));
        Assert.assertArrayEquals(new int[] { 4, 9 }, intersection2(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 }));
    }
}
