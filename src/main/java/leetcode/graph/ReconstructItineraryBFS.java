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
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.computeIfAbsent(from, val -> new ArrayList<>());
            graph.get(from).add(to);
        }
        // sort adj list in ascn
        graph.forEach((key, value) -> Collections.sort(value));

        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");

        List<String> results = new ArrayList<>();
        while (!stack.isEmpty()) {
            String from = stack.peek();
            if (!graph.containsKey(from) || graph.get(from).isEmpty()) { // no neighbours on this, we can pop it off and add to our result
                stack.pop();
                results.add(0, from);
            } else {
                // push the first neighbour onto the queue , remove that edge from our adj list
                List<String> adj = graph.get(from);
                String s = adj.get(adj.size() - 1);
                stack.push(s);
                graph.get(from).remove(adj.size() - 1);
            }
        }

        //Collections.reverse(results);
        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("JFK", "MUC", "LHR", "SFO", "SJC"), findItinerary(List.of(List.of("MUC", "LHR"), List.of("JFK", "MUC"), List.of("SFO", "SJC"), List.of("LHR", "SFO"))));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of("JFK", "NRT", "JFK", "KUL"), findItinerary(List.of(List.of("JFK", "KUL"), List.of("JFK", "NRT"), List.of("NRT", "JFK"))));
    }
}
