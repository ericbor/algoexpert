package array.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up
public class MinConsecutiveCards {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            map.put(card, map.getOrDefault(card, 0) + 1);
            while (map.get(card) == 2) {
                min = Math.min(min, i - start + 1);
                map.put(cards[start], map.get(cards[start]) - 1);
                start++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
