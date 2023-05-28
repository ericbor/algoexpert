package other;

import java.util.*;

//https://leetcode.com/discuss/interview-question/3268118/Pure-Storage-or-OA-2022
public class RacingCar {
    private final Queue<Map.Entry<Integer, Integer>> maxPointsHeap = new PriorityQueue<>((a, b) -> {
        if (Objects.equals(b.getValue(), a.getValue())) {
            return a.getKey() - b.getKey();
        }

        return b.getValue() - a.getValue();
    });
    private final Queue<Integer> zeroPointRacerMinHeap = new PriorityQueue<>((a, b) -> a - b);
    private static final Map<Integer, Integer> POINTS = Map.of(1, 10, 2, 6, 3, 4, 4, 3, 5, 2, 6, 1);

    public void printClasification(int[][] data) {
        Map<Integer, Integer> results = new HashMap<>();
        Set<Integer> zeroPointsPlayers = new HashSet<>();
        int maxPoints = Integer.MIN_VALUE;
        int winnerNum = Integer.MAX_VALUE;

        for (int[] race : data) {
            int racerNum = race[1];
            int place = race[2];
            int points = POINTS.containsKey(place) ? POINTS.get(place) : 0;
            if (points > 0) {
                results.put(racerNum, results.getOrDefault(racerNum, 0) + points);
                zeroPointsPlayers.remove(racerNum);
            } else {
                zeroPointsPlayers.add(racerNum);
            }


            if (points >= maxPoints && racerNum < winnerNum) {
                maxPoints = points;
                winnerNum = racerNum;
            }
        }

        System.out.println(winnerNum + " " + results.get(winnerNum));
        for(int zeroPointRacer: zeroPointsPlayers) {
            System.out.print(zeroPointRacer + " ");
        }
    }

    public void printClasification2(int[][] data) {
        Map<Integer, Integer> results = new HashMap<>();
        for (int[] race : data) {
            int racer = race[1];
            int place = race[2];
            int points = POINTS.containsKey(place) ? POINTS.get(place) : 0;
            results.put(racer, results.getOrDefault(racer, 0) + points);
        }

        for(Map.Entry<Integer, Integer> entry : results.entrySet()) {
            if(entry.getValue() == 0) {
                zeroPointRacerMinHeap.add(entry.getKey());
            } else {
                maxPointsHeap.add(entry);
            }
        }


        printWinner(maxPointsHeap.peek().getKey(), maxPointsHeap.peek().getValue());
        printZeroResults();
    }

    private void printZeroResults() {
        StringBuilder sb = new StringBuilder();
        while(!zeroPointRacerMinHeap.isEmpty()) {
            sb.append(zeroPointRacerMinHeap.poll()).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private void printWinner(int player, int points) {
        System.out.println(player + " " + points);
    }

    public static void main(String[] args) {
        RacingCar rc = new RacingCar();
        rc.printClasification(new int[][]{
                {2001, 1001, 3},
                {2001, 1002, 2},
                {2002, 1003, 1},
                {2002, 1001, 2},
                {2002, 1002, 3},
                {2001, 1003, 1},
                {2001, 1005, 7},
                {2002, 1005, 8},
                {2001, 1004, 7},
                {2002, 1004, 8}});
        System.out.println("------------------------");
        rc.printClasification2(new int[][]{
                {2001, 1001, 3},
                {2001, 1002, 2},
                {2002, 1003, 1},
                {2002, 1001, 2},
                {2002, 1002, 3},
                {2001, 1003, 1},
                {2001, 1005, 7},
                {2002, 1005, 8},
                {2001, 1004, 7},
                {2002, 1004, 8}});
    }
}
