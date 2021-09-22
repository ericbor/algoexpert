package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSum2 {
    public static List<List<Integer>> searchTriplets2(int[] arr, int target) {
        Arrays.sort(arr);

        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum >= target) {
                    right--;
                } else {// Else move left corner
                    for (int k = right; k > left; k--) {
                        triplets.add(Arrays.asList(arr[i], arr[left], arr[k]));
                    }
                    left++;
                }
            }
        }

        return triplets;
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(List.of(-1, 1, 4), List.of(-1, 1, 3), List.of(-1, 1, 2), List.of(-1, 2, 3)), searchTriplets2(new int[] { -1, 4, 2, 1, 3 }, 5));
        Assert.assertEquals(List.of(List.of(-1, 0, 3), List.of(-1, 0, 2)), searchTriplets2(new int[] { -1, 0, 2, 3 }, 3));
    }
}
