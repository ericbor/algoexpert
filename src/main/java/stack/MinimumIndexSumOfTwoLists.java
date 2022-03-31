package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/minimum-index-sum-of-two-lists/
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> list1Map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            list1Map.put(list1[i], i);
        }

        Queue<Match> minHeap = new PriorityQueue<>((a, b) -> a.indexScore - b.indexScore);

        for (int i = 0; i < list2.length; i++) {
            if (list1Map.containsKey(list2[i])) {
                Match match = new Match(list2[i], list1Map.get(list2[i]) + i);

                if (minHeap.isEmpty() || minHeap.peek().indexScore == match.indexScore) {
                    minHeap.add(match);
                } else if (minHeap.peek().indexScore > match.indexScore) {
                    while (!minHeap.isEmpty()) {
                        minHeap.poll();
                    }
                    minHeap.add(match);
                }
            }
        }

        String[] results = new String[minHeap.size()];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            results[idx] = minHeap.poll().restaurant;
            idx++;
        }

        return results;
    }

    class Match {
        String restaurant;
        int indexScore;

        public Match(String restaurnat, int indexScore) {
            this.restaurant = restaurnat;
            this.indexScore = indexScore;
        }
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new String[] { "Shogun" }, findRestaurant(new String[] {
            "Shogun", "Tapioca Express", "Burger King", "KFC" }, new String[] { "KFC", "Shogun", "Burger King" }));
    }
}
