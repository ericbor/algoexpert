package educative.twopointers.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero2 {

    public static List<List<Integer>> searchTriplets2(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum == 0) { //found the triplet
                    triplets.add(List.of(arr[i], arr[left], arr[right]));

                    left++;
                    right--;

                    while (left < right && arr[left] == arr[left - 1]) {
                        left++;// skip same element to avoid duplicate triplets
                    }

                    while (left < right && arr[right] == arr[right + 1]) {
                        right--;// skip same element to avoid duplicate triplets
                    }
                } else if (currentSum < 0) {
                    left++; // we need a pair with a bigger sum
                } else {
                    right--; // we need a pair with a smaller sum
                }
            }
        }
        return triplets;
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(List.of(-3, 1, 2), List.of(-2, 0, 2), List.of(-2, 1, 1), List.of(-1, 0, 1)), searchTriplets2(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        Assert.assertEquals(List.of(List.of(-5, 2, 3), List.of(-2, -1, 3)), searchTriplets2(new int[] { -5, 2, -1, -2, 3 }));
    }
}
