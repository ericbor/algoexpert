package array.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int leftIndex = 0;
        int rightIndex = array.size() - 1;

        while (leftIndex < rightIndex) {
            int leftNum = array.get(leftIndex);
            int rightNum = array.get(rightIndex);
            if (leftNum == toMove) {
                if (rightNum != toMove) {
                    swap(leftIndex, rightIndex, array);

                    rightIndex--;
                } else {
                    rightIndex--;
                }
            } else {
                leftIndex++;
            }
        }

        return array;
    }

    public static List<Integer> moveElementToEndV2(List<Integer> array, int toMove) {
        int leftIndex = 0;
        int rightIndex = array.size() - 1;

        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array.get(rightIndex) == toMove) {
                rightIndex--;
            }
            if (array.get(leftIndex) == toMove) {
                swap(leftIndex, rightIndex, array);
            }
            leftIndex++;
        }

        return array;
    }

    private static void swap(int leftIndex, int rightIndex, List<Integer> array) {
        int tmp = array.get(leftIndex);
        array.set(leftIndex, array.get(rightIndex));
        array.set(rightIndex, tmp);
    }

    @Test
    public void verify() {
        Assert.assertEquals(List.of(4, 1, 3, 2, 2, 2, 2, 2), moveElementToEnd(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2));
        Assert.assertEquals(List.of(4, 1, 3, 2, 2, 2, 2, 2), moveElementToEndV2(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2));
    }
}
