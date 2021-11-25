package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
public class MoveAllBallsToEachBox {
    public int[] minOperations2(String boxes) {
        int[] results = new int[boxes.length()];

        for (int i = 0; i < boxes.length(); i++) {
            int counter = 0;
            for (int k = 0; k < boxes.length(); k++) {
                if (k != i && boxes.charAt(k) == '1') {
                    counter += Math.abs(k - i);
                }
            }

            results[i] = counter;
        }

        return results;
    }

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        char[] ch = boxes.toCharArray();

        int[] left = new int[n];
        int count = ch[0] - '0';

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + count;
            count += ch[i] - '0';
        }

        int right[] = new int[n];
        count = ch[n - 1] - '0';

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            count += ch[i] - '0';
        }

        for (int i = 0; i < n; i++) {
            left[i] += right[i];
        }

        return left;
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 11, 8, 5, 4, 3, 4 }, minOperations("001011"));
    }
}
