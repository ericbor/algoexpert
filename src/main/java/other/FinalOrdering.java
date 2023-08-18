package other;

import java.util.*;

//Given a list of orderings (A>B, B>C, B>D, D>C, E>C,D>E), how can you return the final ordering?
public class FinalOrdering {
    public static Map<String, List<String>> constructGraph(List<String> orderings) {
        Map<String, List<String>> graph = new HashMap<>();
        for (String ordering : orderings) {
            String[] parts = ordering.split(">");
            String first = parts[0];
            String second = parts[1];

            if (!graph.containsKey(first)) {
                graph.put(first, new ArrayList<>());
            }
            graph.get(first).add(second);
        }

        return graph;
    }

    public static List<String> topologicalSort(Map<String, List<String>> graph) {
        Map<String, Integer> inDegree = new HashMap<>();
        for (String node : graph.keySet()) {
            inDegree.put(node, 0);
        }

        for (List<String> strings : graph.values()) {
            for (String neighbor : strings) {
                inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (String node : graph.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String node = queue.poll();
            result.add(node);
            for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> orderings = Arrays.asList("A>B", "B>C", "B>D", "D>C", "E>C", "D>E");
        Map<String, List<String>> graph = constructGraph(orderings);
        List<String> finalOrdering = topologicalSort(graph);

        System.out.println("Final ordering: " + finalOrdering);
    }
}
