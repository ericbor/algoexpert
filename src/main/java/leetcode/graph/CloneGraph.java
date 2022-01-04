package leetcode.graph;

import leetcode.graph.design.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/clone-graph/
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        // Hash map to save the visited node and its respective clone
        // as key and value respectively. This helps to avoid cycles.
        Map<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val, node.neighbors));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new Node(neighbor.val, neighbor.neighbors));
                    // Add the newly encountered node to the queue.
                    queue.add(node);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "curr".
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the node from visited.
        return visited.get(node);
    }
}
