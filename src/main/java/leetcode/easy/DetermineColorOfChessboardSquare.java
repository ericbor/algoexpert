package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/determine-color-of-a-chessboard-square/
public class DetermineColorOfChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        char letter = coordinates.charAt(0);
        char digit = coordinates.charAt(1);

        int digitNum = (int) digit - (int) '0';
        int letterNum = (int) letter - (int) 'a' + 1;

        boolean isEven = letterNum % 2 == 0;

        if (isEven) {
            return digitNum % 2 != 0;
        }

        return digitNum % 2 == 0;
    }

    //a1 = 1+1 = 2 (even -> black)
    //a2 = 1+2 = 3 (odd -> white)
    //b1 = 2+1 = 3 (odd -> white)
    //b2 = 2+2 = 4 (even -> black)
    public boolean squareIsWhite2(String coordinates) {
        char letter = coordinates.charAt(0);
        char digit = coordinates.charAt(1);

        int digitNum = (int)digit - (int)'0';
        int letterNum = (int)letter - (int)'a' + 1;

        return (digitNum + letterNum) % 2 != 0;
    }

    @Test
    public void test() {
        Assert.assertFalse(squareIsWhite("a1"));
        Assert.assertTrue(squareIsWhite("b1"));
        Assert.assertTrue(squareIsWhite("a2"));
        Assert.assertFalse(squareIsWhite("b2"));
    }

}
