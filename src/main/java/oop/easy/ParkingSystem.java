package oop.easy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingSystem {
    private final Map<Integer, Integer> parkingMap;

    public ParkingSystem(int big, int medium, int small) {
        parkingMap = new ConcurrentHashMap<>(3);
        parkingMap.put(1, big);
        parkingMap.put(2, medium);
        parkingMap.put(3, small);
    }

    public boolean addCar(int carType) {
        if (!parkingMap.containsKey(carType) || parkingMap.get(carType) == 0) {
            return false;
        }
        parkingMap.put(carType, parkingMap.get(carType) - 1);
        return true;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }
}
