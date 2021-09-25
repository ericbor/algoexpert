package educative.fastslowpointers.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Happy Number  - if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’.
All other (not-happy) numbers will never reach ‘1’.
Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

23 (happy)
13 -> 10 -> 1
1) 2^2 + 3^2 = 4 + 9 = 13 -> 10 -> 1
2) 1^2 + 3^2 = 1 + 9 = 10
3) 1^2 + 0^2 = 1 + 0 = 1

12 (no happy)
89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89

Solution: The process always ends in a cycle.
If the number is a happy number, the process will be stuck in a cycle on number ‘1,’.
And if the number is not a happy number then the process will be stuck in a cycle with a set of numbers.
 */
public class HappyNumber {
    public static boolean find(int num) {
        int slow = num;
        int fast = num;
        do {
            slow = findSquareSum(slow);
            fast = findSquareSum(findSquareSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private static int findSquareSum(int num) {
        int sum = 0;
        while (num > 0) {
            int reminder = num % 10;
            sum += reminder * reminder;
            num /= 10;
        }

        return sum;
    }

    @Test
    public void verify() {
        Assert.assertTrue(find(23));
        Assert.assertFalse(find(12));
    }
}
