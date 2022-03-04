package leetcode.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/reconstruct-itinerary/
public class ReconstructItinerary {

    // origin -> list of destinations
    private final Map<String, LinkedList<String>> flightMap = new HashMap<>();
    private final LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1). build the graph first
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            flightMap.computeIfAbsent(from, key -> new LinkedList<>());

            flightMap.get(from).add(to);
        }

        // Step 2). order the destinations
        flightMap.forEach((key, value) -> Collections.sort(value));

        // Step 3). post-order DFS
        dfs("JFK");

        return result;
    }

    protected void dfs(String from) {
        // Visit all the outgoing edges first.
        if (flightMap.containsKey(from)) {
            LinkedList<String> toList = flightMap.get(from);
            while (!toList.isEmpty()) {
                // while we visit the edge, we trim it off from graph.
                String to = toList.pollFirst();
                dfs(to);
            }
        }
        // add the airport to the head of the itinerary
        result.offerFirst(from);
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("JFK", "NRT", "JFK", "KUL"), findItinerary(List.of(List.of("JFK", "KUL"), List.of("JFK", "NRT"), List.of("NRT", "JFK"))));
    }
}
