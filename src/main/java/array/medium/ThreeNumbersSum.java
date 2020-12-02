package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumbersSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int potentialSum = array[i] + array[left] + array[right];
                if (potentialSum < targetSum) {
                    left++;
                } else if (potentialSum > targetSum) {
                    right--;
                } else {
                    Integer[] match = { array[i], array[left], array[right] };
                    result.add(match);
                    left++;
                    right--;
                }
            }
        }

        return result;
    }

    @Test
    public void verify() {
        List<Integer[]> expectedResult = new ArrayList<>();
        Integer[] first = {-8, 2, 6};
        expectedResult.add(first);
        Integer[] second = {-8, 3, 5};
        expectedResult.add(second);
        Integer[] third = {-6, 1, 5};
        expectedResult.add(third);

        List<Integer[]> result = threeNumberSum(new int[] { 12, 3, 1, 2, -6, 5, -8, 6 }, 0);

        Assert.assertArrayEquals(expectedResult.get(0), result.get(0));
        Assert.assertArrayEquals(expectedResult.get(1), result.get(1));
        Assert.assertArrayEquals(expectedResult.get(2), result.get(2));
    }
}
