package practice.airbnb;

import java.util.*;

// https://leetcode.com/discuss/interview-question/124861/Airbnb-or-Cover-all-vertices-with-the-least-number-of-vertices
public class CoverAllVerticesWithTheLeastNumberOfVertices {

//    int res = 0;
//
//    public int findMinNodesBfs(int nodes, int[][] edges) {
//        boolean[] visited = new boolean[nodes];
//        for (int i = 0; i < nodes; i++) {
//            if (!visited[i]) {
//                bfs(i, visited, edges);
//                res++;
//            }
//        }
//        return res;
//    }
//
//    private void bfs(int node, boolean[] visited, int[][] edges) {
//        Queue<Integer> q = new LinkedList<>();
//        visited[node] = true;
//        q.offer(node);
//        while (!q.isEmpty()) {
//            int cur = q.poll();
//            for (int[] e : edges) {
//                if (cur == e[0]) {
//                    if (!visited[e[1]]) {
//                        visited[e[1]] = true;
//                        q.offer(e[1]);
//                    }
//                }
//            }
//        }
//    }

    public int findMinNodes(int nodes, int[][] edges) {
        int[] parent = new int[nodes];
        for (int i = 0; i < nodes; i++)
            parent[i] = i;
        for (int[] e : edges) {
            union(parent, e[0], e[1]);
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            map.putIfAbsent(find(parent, i), new HashSet<>());
            map.get(find(parent, i)).add(i);
        }
        return map.size();
    }

    private int find(int[] parent, int a) {
        while (a != parent[a]) {
            parent[a] = parent[parent[a]];
            a = parent[a];
        }
        return a;
    }

    private void union(int[] parent, int a, int b) {
        int aP = find(parent, a);
        int bP = find(parent, b);
        if (aP != bP)
            parent[aP] = bP;
    }
}
