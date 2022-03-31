package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
public class FilterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (b[1] == a[1]) {
                return b[0] - a[0];
            }

            return b[1] - a[1];
        });

        boolean isVeganRequired = veganFriendly == 1;

        for (int[] restaurant : restaurants) {
            if (isVeganRequired && restaurant[2] != 1) {
                continue;
            }
            if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                maxHeap.add(new int[] { restaurant[0], restaurant[1] });
            }
        }

        List<Integer> list = new ArrayList<>(maxHeap.size());
        while (!maxHeap.isEmpty()) {
            list.add(maxHeap.poll()[0]);
        }

        return list;
    }
}
