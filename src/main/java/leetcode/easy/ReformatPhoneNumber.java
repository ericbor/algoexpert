package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/reformat-phone-number/
public class ReformatPhoneNumber {
    public String reformatNumber(String number) {
        Queue<Integer> queue = new LinkedList<>();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                int difit = (int) c - (int) '0';
                queue.add(difit);
            }
        }

        StringBuilder sb = new StringBuilder();
        int max = getMax(queue.size());
        int currLength = 0;

        while (!queue.isEmpty()) {
            if (currLength == max) {
                sb.append("-");
                currLength = 0;

                max = getMax(queue.size());
            }

            int digit = queue.poll();
            sb.append(digit);
            currLength++;
        }

        return sb.toString();
    }

    private int getMax(int size) {
        if (size > 4 || size == 3) {
            return 3;
        }

        return 2;
    }

    @Test
    public void test() {
        Assert.assertEquals("123-456", reformatNumber("1-23-45 6"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("123-45-67", reformatNumber("123 4-567"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("123", reformatNumber("123"));
    }

    @Test
    public void test4() {
        Assert.assertEquals("12-34", reformatNumber("1234"));
    }
}
