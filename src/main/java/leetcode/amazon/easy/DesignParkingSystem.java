package leetcode.amazon.easy;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-parking-system/
public class DesignParkingSystem {
    Map<Integer, Integer> carSlots = new HashMap();
    Map<Integer, Integer> capacityByCarType = new HashMap();

    public DesignParkingSystem(int big, int medium, int small) {
        carSlots.put(1, big);
        carSlots.put(2, medium);
        carSlots.put(3, small);

        capacityByCarType.put(1, 0);
        capacityByCarType.put(2, 0);
        capacityByCarType.put(3, 0);
    }

    public boolean addCar(int carType) {
        int size = carSlots.get(carType);
        int occupiedSlots = capacityByCarType.get(carType);

        if(size >  occupiedSlots) {
            occupiedSlots++;
            capacityByCarType.put(carType, occupiedSlots);

            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        DesignParkingSystem ps = new DesignParkingSystem(1,1,0);
        Assert.assertTrue(ps.addCar(1));
        Assert.assertTrue(ps.addCar(2));
        Assert.assertFalse(ps.addCar(3));
    }
}
