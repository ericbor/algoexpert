package leetcode.amazon.easy;

import org.junit.Assert;

//https://leetcode.com/problems/design-parking-system/
public class DesignParkingSystem2 {
    int[] slots = new int[3];

    public DesignParkingSystem2(int big, int medium, int small) {
        slots[0] = big;
        slots[1] = medium;
        slots[2] = small;
    }

    public boolean addCar(int carType) {
        int availableSlots = slots[carType - 1];
        if (availableSlots > 0) {
            slots[carType - 1]--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        DesignParkingSystem2 ps = new DesignParkingSystem2(1, 1, 0);
        Assert.assertTrue(ps.addCar(1));
        Assert.assertTrue(ps.addCar(2));
        Assert.assertFalse(ps.addCar(3));
    }
}
