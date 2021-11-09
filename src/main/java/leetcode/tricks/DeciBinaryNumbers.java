package leetcode.tricks;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
public class DeciBinaryNumbers {
    public int minPartitions(String n) {
        int maximum = 0;
        for (int i = 0; i < n.length(); i++) {
            int num = (int) n.charAt(i) - (int) '0';
            maximum = Math.max(maximum, num);
        }
        return maximum;
    }

    @Test
    public void test() {
        Assert.assertEquals(8, minPartitions("82734"));
    }
}
