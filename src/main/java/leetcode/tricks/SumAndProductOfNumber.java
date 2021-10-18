package leetcode.tricks;

//https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/submissions/
public class SumAndProductOfNumber {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;

        while (n > 0) {
            int reminder = n % 10;
            sum += reminder;
            product *= reminder;

            n = n / 10;
        }

        return product - sum;
    }
}
