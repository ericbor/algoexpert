package array;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/car-pooling/
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] increase = new int[1001];
        for (int[] trip : trips) { // find out the number of the **net increase** passengers for each stop
            increase[trip[1]] += trip[0];
            increase[trip[2]] -= trip[0];
        }

        int inCar = 0;
        for (int i = 0; i <= 1000; i++) { // from start to end, for each stop we calculate the number of passengers in the car.
            inCar += increase[i];
            if (inCar > capacity) {
                return false; // once the number of passengers in the car exceeds the capacity
            }
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertFalse(carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 4));
    }

    @Test
    public void test2() {
        Assert.assertTrue(carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 5));
    }
}
