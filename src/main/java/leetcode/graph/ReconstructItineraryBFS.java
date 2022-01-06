package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/reconstruct-itinerary/
public class ReconstructItineraryBFS {


    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> graph = new HashMap<>();
        // build graph
        for (List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);

            List<String> neighbours = graph.getOrDefault(from, new ArrayList<>());
            neighbours.add(to);
            graph.put(from, neighbours);
        }
        // sort adj list in ascn
        graph.forEach((key, value) -> Collections.sort(value));

        Queue<String> queue = new LinkedList<>();
        queue.add("JFK");

        List<String> results = new ArrayList<>();
        while(!queue.isEmpty()){
            String from = queue.poll();
            if (!graph.containsKey(from) || graph.get(from).isEmpty()){ // no neighbours on this, we can pop it off and add to our result
                queue.poll();
                results.add(from);
            } else {
                // push the first neighbour onto the queue , remove that edge from our adj list
                List<String> adj = graph.get(from);
                String s = adj.get(adj.size() - 1);
                queue.add(s);
                graph.get(from).remove(adj.size() - 1);
            }
        }

        Collections.reverse(results);
        return results;
    }


    @Test
    public void test() {
        Assert.assertEquals(List.of("JFK", "NRT", "JFK", "KUL"), findItinerary(List.of(List.of("JFK", "KUL"), List.of("JFK", "NRT"), List.of("NRT", "JFK"))));
    }
}
