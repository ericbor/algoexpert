package leetcode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/keys-and-rooms/
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        int roomsVisited = 0;

        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited[curr]) {
                continue;
            }

            visited[curr] = true;
            roomsVisited++;

            for (int key : rooms.get(curr)) {
                queue.add(key);
            }
        }

        return n == roomsVisited;
    }
}
