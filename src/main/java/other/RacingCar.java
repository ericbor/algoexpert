package other;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/discuss/interview-question/3268118/Pure-Storage-or-OA-2022
public class RacingCar {
    private static final Map<Integer, Integer> POINTS = Map.of(1, 10, 2, 6, 3, 4, 4, 3, 5, 2, 6, 1);

    public void printClasification(int[][] data) {
        Map<Integer, Integer> results = new HashMap<>();
        int maxPoint = Integer.MIN_VALUE;
        int winner = 0;

        for (int[] race : data) {
            int racer = race[1];
            int place = race[2];
            int points = POINTS.containsKey(place) ? POINTS.get(place) : 0;
            results.put(racer, results.getOrDefault(racer, 0) + points);

            if (points > maxPoint) {
                maxPoint = points;
                winner = racer;
            }
        }

        System.out.println(winner + " " + results.get(winner));
    }

    public static void main(String[] args) {
        RacingCar rc = new RacingCar();
        rc.printClasification(new int[][]{
                {2001, 1001, 3},
                {2001, 1002, 2},
                {2002, 1003, 1},
                {2002, 1001, 2},
                {2002, 1002, 3},
                {2001, 1003, 1}});
    }
}
