package array.easy;

//https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
public class FindNumberswithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int digitNumer = getDigitNumber(num);
            if (digitNumer % 2 == 0) {
                result++;
            }
        }

        return result;
    }

    private int getDigitNumber(int num) {
        int counter = 0;
        while (num != 0) {
            num /= 10;
            counter++;
        }

        return counter;
    }
}
