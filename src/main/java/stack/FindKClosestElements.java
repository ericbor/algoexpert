package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/find-k-closest-elements/
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {
            int absA = Math.abs(a - x);
            int absB = Math.abs(b - x);
            if(absA == absB) {
                return b - a;
            }

            return absB - absA;
        });

        for(int num: arr) {
            maxHeap.add(num);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> results = new ArrayList<>();
        while(!maxHeap.isEmpty()) {
            results.add(maxHeap.poll());
        }

        Collections.sort(results);

        return results;
    }
}
