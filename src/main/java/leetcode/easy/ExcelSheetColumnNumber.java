package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/excel-sheet-column-number/
public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int sum = 0;

        for(int i = 0; i < columnTitle.length(); i++){
            int toPower = columnTitle.length() - 1 - i;
            char curr = columnTitle.charAt(i);

            int num = (int)curr - (int)'A' + 1;
            int result = num * (int)Math.pow(26, toPower);

            sum += result;
        }

        return sum;
    }

    public int titleToNumber2(String columnTitle) {
        int sum = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            sum *= 26;

            char curr = columnTitle.charAt(i);
            int num = (int) curr - (int) 'A' + 1;

            sum += num;
        }

        return sum;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, titleToNumber("A"));
        Assert.assertEquals(1, titleToNumber2("A"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(28, titleToNumber("AB"));
        Assert.assertEquals(28, titleToNumber2("AB"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(701, titleToNumber("ZY"));
        Assert.assertEquals(701, titleToNumber2("ZY"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(2147483647, titleToNumber("FXSHRXW"));
        Assert.assertEquals(2147483647, titleToNumber2("FXSHRXW"));
    }

    @Test
    public void test5() {
        Assert.assertEquals(73116, titleToNumber("DDDD"));
        Assert.assertEquals(73116, titleToNumber2("DDDD"));
    }

    @Test
    public void test6() {
        Assert.assertEquals(214442, titleToNumber2("LEET"));
        Assert.assertEquals(214442, titleToNumber("LEET"));
    }
}
