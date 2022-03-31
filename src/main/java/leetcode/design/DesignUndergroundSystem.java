package leetcode.design;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-underground-system/
public class DesignUndergroundSystem {
    private final Map<String, Trip> tripData = new HashMap<>();
    private final Map<Integer, CheckIn> checkInData = new HashMap<>();

    public void checkIn(int id, String stationName, int t) {
        checkInData.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkInDataForId = checkInData.get(id);
        String from = checkInDataForId.from;
        int checkInTime = checkInDataForId.time;

        // Lookup the current travel time data for this route.
        String routeKey = stationsKey(from, stationName);
        Trip routeStats = tripData.getOrDefault(routeKey, new Trip(0.0, 0.0));

        // Update the travel time data with this trip.
        double currTripTime = t - checkInTime;
        tripData.put(routeKey, new Trip(routeStats.totalTripTime + currTripTime, routeStats.totalTrips + 1));

        // Remove check in data for this id.
        // Note that this is optional, we'll talk about it in the space complexity analysis.
        //checkInData.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        // Lookup how many times this journey has been made, and the total time.
        String routeKey = stationsKey(startStation, endStation);
        Double totalTime = tripData.get(routeKey).totalTripTime;
        Double totalTrips = tripData.get(routeKey).totalTrips;
        // The average is simply the total divided by the number of trips.
        return totalTime / totalTrips;
    }

    private String stationsKey(String startStation, String endStation) {
        return startStation + "->" + endStation;
    }
}

class CheckIn {
    String from;
    int time;

    public CheckIn(String from, int time) {
        this.from = from;
        this.time = time;
    }
}

class Trip {
    Double totalTripTime;
    Double totalTrips;

    public Trip(Double totalTripTime, Double totalTrips) {
        this.totalTripTime = totalTripTime;
        this.totalTrips = totalTrips;
    }
}

