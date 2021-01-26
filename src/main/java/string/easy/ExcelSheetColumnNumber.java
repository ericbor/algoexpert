package string.easy;

import org.junit.Assert;
import org.junit.Test;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int columnNumber = 0;

        for(char c: s.toCharArray()) {
            if(columnNumber != 0) {
                columnNumber += 25;
            }
            columnNumber += (int) c - (int) 'A' + 1;
        }

        return columnNumber;
    }

    @Test
    public void verify() {
        Assert.assertEquals(28, titleToNumber("AB"));
    }
}
