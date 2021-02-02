package oop.easy;

public class ParkingSystem2 {
    private final int[] parkingSpots;

    public ParkingSystem2(int big, int medium, int small) {
        parkingSpots = new int[] { big, medium, small };
    }

    public boolean addCar(int carType) {
        if (parkingSpots[carType - 1] > 0) {
            parkingSpots[carType - 1]--;
            return true;
        }
        return false;

    }
}
