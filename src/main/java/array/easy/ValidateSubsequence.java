package array.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ValidateSubsequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        if (array.size() < sequence.size()) {
            return false;
        }

        int seqIndex = 0;

        for (Integer num : array) {
            if (sequence.get(seqIndex).equals(num)) {
                ++seqIndex;
            }
            if (sequence.size() == seqIndex) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void verify() {
        Assert.assertTrue(isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, 10)));
    }
}
