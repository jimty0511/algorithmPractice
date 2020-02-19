package practice.airbnb;

import practice.problem.ShortestPathVisitingAllNodes;

import java.util.*;

// https://leetcode.com/discuss/interview-question/125093/Airbnb-or-Shortest-path-in-a-directed-graph-that-can-visit-each-vertex-at-least-once
public class ShortestPathInDirectedGraphThatCanVisitEachVertexAtLeastOnce {
    class Node {
        int id;
        int mask;

        public Node(int id, int mask) {
            this.id = id;
            this.mask = mask;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", mask=" + mask +
                    '}';
        }
    }

    public int shortestPathLength(int nodes, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= nodes; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }
        int n = graph.size();
        int fullMask = (1 << n) - 1;
        Set<String> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i + 1, 1 << i);
            q.offer(node);
            visited.add(node.toString());
        }
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.mask == fullMask)
                    return level;
                for (int next : graph.get(node.id)) {
                    Node nextNode = new Node(next, node.mask | (1 << next));
                    if (!visited.contains(nextNode.toString())) {
                        q.offer(nextNode);
                        visited.add(nextNode.toString());
                    }
                }
            }
            level++;
        }
        return level;
    }
}
