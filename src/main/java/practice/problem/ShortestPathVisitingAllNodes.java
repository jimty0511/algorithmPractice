package practice.problem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 847. Shortest Path Visiting All Nodes
public class ShortestPathVisitingAllNodes {

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

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;
        Set<String> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, 1 << i);
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
                for (int next : graph[node.id]) {
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
